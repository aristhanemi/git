/*
 * To change AppFormVars template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayantan.commons;

import com.sayantan.DAO.ConnectionManager;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class AppFormVars {

    private static Connection conn = ConnectionManager.getConnection();
    private static Statement stmt = null;
    private static ResultSet rsDataSet = null;
    private static ArrayList<TabFormVars> tradeParams = new ArrayList<>();
    private static ArrayList<TabFormVars> positionParams = new ArrayList<>();
    public static Object[][] jTable1ListValues;
    public static Object[][] jTable2ListValues;
    public static Object[][] jTable3ListValues;

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        AppFormVars.conn = conn;
    }

    public static ArrayList<TabFormVars> getPositionParams() {
        return positionParams;
    }

    public static void setPositionParams(ArrayList<TabFormVars> positionParams) {
        AppFormVars.positionParams = positionParams;
    }

    public static ArrayList<TabFormVars> getTradeParams() {
        return tradeParams;
    }

    public static void setTradeParams(ArrayList<TabFormVars> tradeParams) {
        AppFormVars.tradeParams = tradeParams;
    }

    public void addPositionParams(String p, String s, String t, Integer a, String c, Integer st, Date e, BigDecimal ppr, BigDecimal cpr, BigDecimal ppm, BigDecimal cpm, BigDecimal pt, BigDecimal ct, BigDecimal dpm, BigDecimal dpt) {
        positionParams.add(new TabFormVars(p, s, t, a, c, st, e, ppr, cpr, ppm, cpm, pt, ct, dpm, dpt));
    }

    public void addTradeParams(String d, String p, String s, String t, Integer a, String c, Integer st, Date e, BigDecimal tpr, BigDecimal cpr, BigDecimal tpm, BigDecimal cpm, BigDecimal pt, BigDecimal ct, BigDecimal dpm, BigDecimal dpt) {
        positionParams.add(new TabFormVars("trade", p, s, t, a, c, st, e, tpr, cpr, tpm, cpm, pt, ct, dpm, dpt));
    }

    public void addPrevTheo(BigDecimal value) {
        addPrevTheo(value);
    }

    public static ResultSet getRsDataSet() {
        return rsDataSet;
    }

    public static void setRsDataSet(ResultSet rsDataSet) {
        AppFormVars.rsDataSet = rsDataSet;
    }

    public static Statement getStmt() {
        return stmt;
    }

    public static void setStmt(Statement stmt) {
        AppFormVars.stmt = stmt;
    }
}
