/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayantan.Action;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.sayantan.commons.AppFormVars;
import com.sayantan.commons.TabFormVars;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class EODProcessV1 {

    /**
     * @param args the command line arguments
     */
    private static final Logger logger = Logger.getLogger(EODProcessV1.class);
    static Document document = new Document();
    AppFormVars formVars = new AppFormVars();
    MathContext mc = new MathContext(0);

    EODProcessV1() throws SQLException {
        logger.info("enter EODProcess");
        String positionQuery = "select * from positionmaster";
        String tradeQuery = "select t.posid, t.stock, t.tradetype, t.amount,  t.callput, t.strike, t.expmatdate, p.prevcloseprice, t.price, p.prevcloseprem, t.premium, p.currentpremtheo from trademaster t, positionmaster p where p.posid=t.posid";

        logger.info("query: " + positionQuery + "\n" + tradeQuery);
        AppFormVars.setStmt(AppFormVars.getConn().createStatement());

        /*
         * set trade-params
         */
        AppFormVars.setRsDataSet(AppFormVars.getStmt().executeQuery(tradeQuery));
        while (AppFormVars.getRsDataSet().next()) {
            logger.info("posid: " + AppFormVars.getRsDataSet().getString("posid"));

            formVars.addTradeParams(
                    "trade",
                    AppFormVars.getRsDataSet().getString("posid"),
                    AppFormVars.getRsDataSet().getString("stock"),
                    AppFormVars.getRsDataSet().getString("tradetype"),
                    Integer.valueOf(AppFormVars.getRsDataSet().getInt("amount")),
                    AppFormVars.getRsDataSet().getString("callput"),
                    Integer.valueOf(AppFormVars.getRsDataSet().getInt("strike")),
                    AppFormVars.getRsDataSet().getDate("expmatdate"),
                    AppFormVars.getRsDataSet().getBigDecimal("prevcloseprice"),
                    AppFormVars.getRsDataSet().getBigDecimal("price"),
                    AppFormVars.getRsDataSet().getBigDecimal("prevcloseprem"),
                    AppFormVars.getRsDataSet().getBigDecimal("premium"),
                    AppFormVars.getRsDataSet().getBigDecimal("currentpremtheo"),
                    null, null, null);
        }

        /*
         * set position-params
         */
        AppFormVars.setRsDataSet(AppFormVars.getStmt().executeQuery(positionQuery));
        while (AppFormVars.getRsDataSet().next()) {
            formVars.addPositionParams(
                    AppFormVars.getRsDataSet().getString("posid"),
                    AppFormVars.getRsDataSet().getString("stock"),
                    AppFormVars.getRsDataSet().getString("tradetype"),
                    Integer.valueOf(AppFormVars.getRsDataSet().getInt("amount")),
                    AppFormVars.getRsDataSet().getString("callput"),
                    Integer.valueOf(AppFormVars.getRsDataSet().getInt("strike")),
                    AppFormVars.getRsDataSet().getDate("expmatdate"),
                    AppFormVars.getRsDataSet().getBigDecimal("prevcloseprice"),
                    AppFormVars.getRsDataSet().getBigDecimal("prevcloseprice"),
                    AppFormVars.getRsDataSet().getBigDecimal("currentprice"),
                    AppFormVars.getRsDataSet().getBigDecimal("currentprem"),
                    null, null, null, null);
        }

        logger.info(//<editor-fold defaultstate="collapsed" desc="comment">
                "Trade Params: " + AppFormVars.getTradeParams() + "\nPosition Params: " + AppFormVars.getPositionParams() //</editor-fold>
                );

        /**
         * P/L calculations DailyMTMPL = (CurrentPrem – PrevPrem)*amount
         * DailyPLTheo= (CurrentPremTheo– PrevPremTheo)*amount
         *
         */
        mc = MathContext.DECIMAL128;
        for (int a = 0; a < AppFormVars.getPositionParams().size(); a++) {
            if (AppFormVars.getPositionParams().get(a).getCurrentPrice() != null
                    && AppFormVars.getPositionParams().get(a).getPrevPrice() != null
                    && AppFormVars.getPositionParams().get(a).getAmount() != null) {
                if (AppFormVars.getPositionParams().get(a).getType().equalsIgnoreCase("Future")
                        || AppFormVars.getPositionParams().get(a).getType().equalsIgnoreCase("Cash")) {
                    BigDecimal dailyOpenFutPl = AppFormVars.getPositionParams().get(a).getCurrentPrice().subtract(AppFormVars.getPositionParams().get(a).getPrevPrice(), mc).multiply(new BigDecimal(AppFormVars.getPositionParams().get(a).getAmount()));
                    AppFormVars.getPositionParams().get(a).setDailyPLmtm(dailyOpenFutPl);
                    AppFormVars.getPositionParams().get(a).setDailyPLtheo(dailyOpenFutPl);
                } else if (AppFormVars.getPositionParams().get(a).getType().equalsIgnoreCase("Position")) {
                }
            }
        }

        /**
         * Create the jTable Array
         */
        AppFormVars.jTable1ListValues = new Object[AppFormVars.getPositionParams().size()][14];
        AppFormVars.jTable2ListValues = new Object[AppFormVars.getPositionParams().size()][14];
        AppFormVars.jTable3ListValues = new Object[AppFormVars.getTradeParams().size()][14];
        logger.info("Size of jTableList: " + AppFormVars.getPositionParams().size() + ":"
                + AppFormVars.jTable3ListValues.length);

        /**
         * open positions j-table
         */
        for (int m = 0; m < AppFormVars.getPositionParams().size(); m++) {
            AppFormVars.jTable2ListValues[m][0] = AppFormVars.getPositionParams().get(m).getSymbol();
            AppFormVars.jTable2ListValues[m][1] = AppFormVars.getPositionParams().get(m).getType();
            AppFormVars.jTable2ListValues[m][2] = AppFormVars.getPositionParams().get(m).getAmount();
            AppFormVars.jTable2ListValues[m][3] = AppFormVars.getPositionParams().get(m).getCp();
            AppFormVars.jTable2ListValues[m][4] = AppFormVars.getPositionParams().get(m).getStrike();
            AppFormVars.jTable2ListValues[m][5] = AppFormVars.getPositionParams().get(m).getExpiration();
            AppFormVars.jTable2ListValues[m][6] = AppFormVars.getPositionParams().get(m).getPrevPrice();
            AppFormVars.jTable2ListValues[m][7] = AppFormVars.getPositionParams().get(m).getCurrentPrice();
            AppFormVars.jTable2ListValues[m][8] = AppFormVars.getPositionParams().get(m).getPrevPrem();
            AppFormVars.jTable2ListValues[m][9] = AppFormVars.getPositionParams().get(m).getCurrentPrem();
            AppFormVars.jTable2ListValues[m][10] = AppFormVars.getPositionParams().get(m).getPrevTheo();
            AppFormVars.jTable2ListValues[m][11] = AppFormVars.getPositionParams().get(m).getCurrentTheo();
            AppFormVars.jTable2ListValues[m][12] = AppFormVars.getPositionParams().get(m).getDailyPLmtm();
            AppFormVars.jTable2ListValues[m][13] = AppFormVars.getPositionParams().get(m).getDailyPLtheo();
        }

        /**
         * today's trades j-table
         */
        for (int m = 0; m < AppFormVars.getTradeParams().size(); m++) {
            AppFormVars.jTable3ListValues[m][0] = AppFormVars.getTradeParams().get(m).getSymbol();
            AppFormVars.jTable3ListValues[m][1] = AppFormVars.getTradeParams().get(m).getType();
            AppFormVars.jTable3ListValues[m][2] = AppFormVars.getTradeParams().get(m).getAmount();
            AppFormVars.jTable3ListValues[m][3] = AppFormVars.getTradeParams().get(m).getCp();
            AppFormVars.jTable3ListValues[m][4] = AppFormVars.getTradeParams().get(m).getStrike();
            AppFormVars.jTable3ListValues[m][5] = AppFormVars.getTradeParams().get(m).getExpiration();
            AppFormVars.jTable3ListValues[m][6] = AppFormVars.getTradeParams().get(m).getPrevPrice();
            AppFormVars.jTable3ListValues[m][7] = AppFormVars.getTradeParams().get(m).getCurrentPrice();
            AppFormVars.jTable3ListValues[m][8] = AppFormVars.getTradeParams().get(m).getPrevPrem();
            AppFormVars.jTable3ListValues[m][9] = AppFormVars.getTradeParams().get(m).getCurrentPrem();
            AppFormVars.jTable3ListValues[m][10] = AppFormVars.getTradeParams().get(m).getPrevTheo();
            AppFormVars.jTable3ListValues[m][11] = AppFormVars.getTradeParams().get(m).getCurrentTheo();
            AppFormVars.jTable3ListValues[m][12] = AppFormVars.getTradeParams().get(m).getDailyPLmtm();
            AppFormVars.jTable3ListValues[m][13] = AppFormVars.getTradeParams().get(m).getDailyPLtheo();
        }

        /**
         * Summary j-table
         */
        for (int m = 0; m < AppFormVars.getPositionParams().size(); m++) {
            AppFormVars.jTable1ListValues[m][0] = AppFormVars.getPositionParams().get(m).getSymbol();
            AppFormVars.jTable1ListValues[m][1] = AppFormVars.getPositionParams().get(m).getDailyPLmtm();
            AppFormVars.jTable1ListValues[m][2] = AppFormVars.getPositionParams().get(m).getDailyPLtheo();
        }

    }

    public static void main(String[] args) throws SQLException {
        FileOutputStream fileOut = null;
        new EODProcessV1();
        /*
         * try { // try { // try { // // TODO code application logic //
         * PdfWriter.getInstance(document, new
         * FileOutputStream("C:/hello.pdf")); // document.open(); // //
         * //document.add(new ed.jTable2); // //document.add(new
         * Paragraph("asdf")); // document.close(); // } catch
         * (FileNotFoundException ex) { //
         * Logger.getLogger(EODProcessV1.class.getName()).log(Level.SEVERE,
         * null, ex); // } // } catch (DocumentException ex) { //
         * Logger.getLogger(EODProcessV1.class.getName()).log(Level.SEVERE,
         * null, ex); // } // //excel Workbook wb = new HSSFWorkbook();
         * System.out.println("kakjsdnhf"); fileOut = new
         * FileOutputStream("c:/workbook.xls"); Sheet sheet1 =
         * wb.createSheet("new sheet"); Sheet sheet2 = wb.createSheet("second
         * sheet"); Row row = sheet1.createRow(0); Cell cell =
         * row.createCell(0); cell.setCellValue("kjahskhdak"); CellStyle
         * cellStyle = wb.createCellStyle();
         * //cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy
         * h:mm")); cell = row.createCell(1); cell.setCellValue(new Date());
         * cell.setCellStyle(cellStyle); System.out.println("kakjsdnhf");
         * wb.write(fileOut); fileOut.close(); System.out.println("kakjsdnhf");
         * } catch (IOException ex) {
         * Logger.getLogger(EODProcessV1.class.getName()).log(Level.SEVERE,
         * null, ex); } finally { try { fileOut.close(); } catch (IOException
         * ex) {
         * Logger.getLogger(EODProcessV1.class.getName()).log(Level.SEVERE,
         * null, ex); } }
         */
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:/hello.pdf"));
            document.open();
            //document.add(new ed.jTable2);
            document.add(new Paragraph("asd6tuyf"));
            document.close();
            System.out.println("1");
        } catch (DocumentException | FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(EODProcessV1.class.getName()).log(Level.SEVERE, null, ex);
        }


        Workbook wb = new HSSFWorkbook();

        System.out.println("2");
        Sheet sheet1 = wb.createSheet("2");
        Row row = sheet1.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("3");
        CellStyle cellStyle = wb.createCellStyle();
        cell = row.createCell(1);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);
        System.out.println("kakjsdnhf");
        try {
            fileOut = new FileOutputStream("c:/workbook.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EODProcessV1.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("kakjsdnhf");
    }
}
