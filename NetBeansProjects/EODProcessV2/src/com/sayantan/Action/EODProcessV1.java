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
import com.sayantan.commons.AppFormVars;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
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
    static EODProcess ed = new EODProcess();
    AppFormVars formVars = new AppFormVars();

    EODProcessV1() throws SQLException {
        logger.info("enter EODProcess");
        String query = "select * from positionmaster";
        logger.info("query: " + query);
        AppFormVars.setStmt(AppFormVars.getConn().createStatement());
        AppFormVars.setRsDataSet(AppFormVars.getStmt().executeQuery(query));
        while (AppFormVars.getRsDataSet().next()) {
            formVars.addSymbol(AppFormVars.getRsDataSet().getString("stock"));
            formVars.addType(AppFormVars.getRsDataSet().getString("tradetype"));
            formVars.addAmount(AppFormVars.getRsDataSet().getInt("amount"));
            formVars.addStrike(AppFormVars.getRsDataSet().getInt("strike"));
            formVars.addCp(AppFormVars.getRsDataSet().getString("callput"));
            formVars.addPrevPrice(AppFormVars.getRsDataSet().getBigDecimal("prevcloseprice"));
            formVars.addPrevPrem(AppFormVars.getRsDataSet().getBigDecimal("prevcloseprice"));
            formVars.addCurrentPrice(AppFormVars.getRsDataSet().getBigDecimal("currentprice"));
            formVars.addCurrentPrem(AppFormVars.getRsDataSet().getBigDecimal("currentprem"));
            formVars.addExpiration(AppFormVars.getRsDataSet().getDate("expmatdate"));
        }
        logger.info(formVars.getSymbol());
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


    }
}
