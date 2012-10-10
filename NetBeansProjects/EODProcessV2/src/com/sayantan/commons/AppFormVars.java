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
    private static  ArrayList<String> symbol = new ArrayList<>();
    private static  ArrayList<String> type = new ArrayList<>();
    private static  ArrayList<Integer> amount = new ArrayList<>();
    private static  ArrayList<String> cp = new ArrayList<>();
    private static  ArrayList<Integer> strike = new ArrayList<>();
    private static  ArrayList<java.sql.Date> expiration = new ArrayList<>();
    private static  ArrayList<BigDecimal> prevPrice = new ArrayList<>();
    private static  ArrayList<BigDecimal> currentPrice = new ArrayList<>();
    private static  ArrayList<BigDecimal> prevPrem = new ArrayList<>();
    private static  ArrayList<BigDecimal> currentPrem = new ArrayList<>();
    private static  ArrayList<BigDecimal> prevTheo = new ArrayList<>();
    private static  ArrayList<BigDecimal> currentTheo = new ArrayList<>();
    private static  ArrayList<BigDecimal> dailyPLmtm = new ArrayList<>();
    private static  ArrayList<BigDecimal> dailyPLtheo = new ArrayList<>();
   
    private static Connection conn = ConnectionManager.getConnection();
    private static Statement stmt = null;
    private static ResultSet rsDataSet = null;

    
    public ArrayList<Integer> getAmount() {
        return amount;
    }

    public static void setAmount(ArrayList<Integer> amount) {
        AppFormVars.amount = amount;
    }

    public void addAmount(Integer value) {
        amount.add(value);
    }
    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        AppFormVars.conn = conn;
    }

    public ArrayList<String> getCp() {
        return cp;
    }

    public static void setCp(ArrayList<String> cp) {
        AppFormVars.cp = cp;
    }
    
    public void addCp(String value) {
        cp.add(value);
    }

    public ArrayList<BigDecimal> getCurrentPrem() {
        return currentPrem;
    }

    public static void setCurrentPrem(ArrayList<BigDecimal> currentPrem) {
        AppFormVars.currentPrem = currentPrem;
    }
    
    public void addCurrentPrem(BigDecimal value) {
        currentPrem.add(value);
    }

    public ArrayList<BigDecimal> getCurrentPrice() {
        return currentPrice;
    }

    public static void setCurrentPrice(ArrayList<BigDecimal> currentPrice) {
        AppFormVars.currentPrice = currentPrice;
    }
    
    public void addCurrentPrice(BigDecimal value) {
        currentPrice.add(value);
    }

    public ArrayList<BigDecimal> getCurrentTheo() {
        return currentTheo;
    }

    public static void setCurrentTheo(ArrayList<BigDecimal> currentTheo) {
        AppFormVars.currentTheo = currentTheo;
    }
    
    public void addCurrentTheo(BigDecimal value) {
        currentTheo.add(value);
    }

    public ArrayList<BigDecimal> getDailyPLmtm() {
        return dailyPLmtm;
    }

    public static void setDailyPLmtm(ArrayList<BigDecimal> dailyPLmtm) {
        AppFormVars.dailyPLmtm = dailyPLmtm;
    }
    
    public void addDailyPLmtm(BigDecimal value){
        dailyPLmtm.add(value);
    }

    public ArrayList<BigDecimal> getDailyPLtheo() {
        return dailyPLtheo;
    }

    public static void setDailyPLtheo(ArrayList<BigDecimal> dailyPLtheo) {
        AppFormVars.dailyPLtheo = dailyPLtheo;
    }
    
    public void addDailyPLtheo(BigDecimal value) {
        dailyPLtheo.add(value);
    }

    public ArrayList<Date> getExpiration() {
        return expiration;
    }

    public static void setExpiration(ArrayList<Date> expiration) {
        AppFormVars.expiration = expiration;
    }
    
    public void addExpiration(Date value) {
        expiration.add(value);
    }

    public ArrayList<BigDecimal> getPrevPrem() {
        return prevPrem;
    }

    public static void setPrevPrem(ArrayList<BigDecimal> prevPrem) {
        AppFormVars.prevPrem = prevPrem;
    }
    
    public void addPrevPrem(BigDecimal value) {
        prevPrem.add(value);
    }

    public ArrayList<BigDecimal> getPrevPrice() {
        return prevPrice;
    }

    public static void setPrevPrice(ArrayList<BigDecimal> prevPrice) {
        AppFormVars.prevPrice = prevPrice;
    }
    
    public void addPrevPrice(BigDecimal value) {
        prevPrice.add(value);
    }

    public ArrayList<BigDecimal> getPrevTheo() {
        return prevTheo;
    }

    public static void setPrevTheo(ArrayList<BigDecimal> prevTheo) {
        AppFormVars.prevTheo = prevTheo;
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

    public ArrayList<Integer> getStrike() {
        return strike;
    }

    public static void setStrike(ArrayList<Integer> strike) {
        AppFormVars.strike = strike;
    }
    
    public void addStrike(Integer value) {
        strike.add(value);
    }

    public ArrayList<String> getSymbol() {
        return symbol;
    }

    public static void setSymbol(ArrayList<String> symbol) {
        AppFormVars.symbol = symbol;
    }

    public void addSymbol(String value) {
        symbol.add(value);
    }
    
    public ArrayList<String> getType() {
        return type;
    }

    public static void setType(ArrayList<String> type) {
        AppFormVars.type = type;
    }
    
    public void addType(String value) {
        type.add(value);
    }
}
