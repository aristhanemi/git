package com.sayantan.commons;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Comparator;

class Geld implements Comparator<OptionParams> {

    @Override
    public int compare(OptionParams p1, OptionParams p2) {
        // TODO Auto-generated method stub
        return p1.getStrike().compareTo(p2.getStrike());
    }
}

public class OptionParams implements Comparable<OptionParams> {

    private static String symbol;
    private static String type;
    private static Integer amount;
    private static String cp;
    private static Integer strike;
    private static java.sql.Date expiration;
    private static BigDecimal prevPrice;
    private static BigDecimal currentPrice;
    private static BigDecimal prevPrem;
    private static BigDecimal currentPrem;
    private static BigDecimal prevTheo;
    private static BigDecimal currentTheo;
    private static BigDecimal dailyPLmtm;
    private static BigDecimal dailyPLtheo;

    public OptionParams(String s, String t, Integer a, String c, Integer st, Date e, BigDecimal ppr, BigDecimal cpr, BigDecimal ppm, BigDecimal cpm, BigDecimal pt, BigDecimal ct, BigDecimal dpm, BigDecimal dpt) {
        symbol = s;
        type = t;
        amount = a;
        cp = c;
        strike = st;
        expiration = e;
        prevPrice = ppr;
        currentPrice = cpr;
        prevPrem = ppm;
        currentPrem = cpm;
        prevTheo = pt;
        currentTheo = ct;
        dailyPLmtm = dpm;
        dailyPLtheo = dpt;
    }

    public static String getSymbol() {
        return symbol;
    }

    public static void setSymbol(String symbol) {
        OptionParams.symbol = symbol;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        OptionParams.type = type;
    }

    public static Integer getAmount() {
        return amount;
    }

    public static void setAmount(Integer amount) {
        OptionParams.amount = amount;
    }

    public static String getCp() {
        return cp;
    }

    public static void setCp(String cp) {
        OptionParams.cp = cp;
    }

    public static Integer getStrike() {
        return strike;
    }

    public static void setStrike(Integer strike) {
        OptionParams.strike = strike;
    }

    public static Date getExpiration() {
        return expiration;
    }

    public static void setExpiration(Date expiration) {
        OptionParams.expiration = expiration;
    }

    public static BigDecimal getPrevPrice() {
        return prevPrice;
    }

    public static void setPrevPrice(BigDecimal prevPrice) {
        OptionParams.prevPrice = prevPrice;
    }

    public static BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public static void setCurrentPrice(BigDecimal currentPrice) {
        OptionParams.currentPrice = currentPrice;
    }

    public static BigDecimal getPrevPrem() {
        return prevPrem;
    }

    public static void setPrevPrem(BigDecimal prevPrem) {
        OptionParams.prevPrem = prevPrem;
    }

    public static BigDecimal getCurrentPrem() {
        return currentPrem;
    }

    public static void setCurrentPrem(BigDecimal currentPrem) {
        OptionParams.currentPrem = currentPrem;
    }

    public static BigDecimal getPrevTheo() {
        return prevTheo;
    }

    public static void setPrevTheo(BigDecimal prevTheo) {
        OptionParams.prevTheo = prevTheo;
    }

    public static BigDecimal getCurrentTheo() {
        return currentTheo;
    }

    public static void setCurrentTheo(BigDecimal currentTheo) {
        OptionParams.currentTheo = currentTheo;
    }

    public static BigDecimal getDailyPLmtm() {
        return dailyPLmtm;
    }

    public static void setDailyPLmtm(BigDecimal dailyPLmtm) {
        OptionParams.dailyPLmtm = dailyPLmtm;
    }

    public static BigDecimal getDailyPLtheo() {
        return dailyPLtheo;
    }

    public static void setDailyPLtheo(BigDecimal dailyPLtheo) {
        OptionParams.dailyPLtheo = dailyPLtheo;
    }

    @Override
    public int compareTo(OptionParams p2) {
        return symbol.compareTo(p2.getSymbol());
    }
}
