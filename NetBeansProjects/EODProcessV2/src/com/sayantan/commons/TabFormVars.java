package com.sayantan.commons;

import java.math.BigDecimal;
import java.sql.Date;

public class TabFormVars implements Comparable<TabFormVars> {
    private String posid;
    private String symbol;
    private String type;
    private Integer amount;
    private String cp;
    private Integer strike;
    private java.sql.Date expiration;
    private BigDecimal prevPrice;
    private BigDecimal tradePrice;
    private BigDecimal currentPrice;
    private BigDecimal prevPrem;
    private BigDecimal tradePrem;
    private BigDecimal currentPrem;
    private BigDecimal prevTheo;
    private BigDecimal currentTheo;
    private BigDecimal dailyPLmtm;
    private BigDecimal dailyPLtheo;

    public TabFormVars(String d, String p, String s, String t, Integer a, String c, Integer st, Date e, BigDecimal tpr, BigDecimal cpr, BigDecimal tpm, BigDecimal cpm, BigDecimal pt, BigDecimal ct, BigDecimal dpm, BigDecimal dpt) {
    d = "trade";
    posid = p;
    symbol = s;
    type = t;
    amount = a;
    cp = c;
    strike = st;
    expiration = e;
    tradePrice = tpr;
    currentPrice = cpr;
    tradePrem = tpm;
    currentPrem = cpm;
    prevTheo = pt;
    currentTheo = ct;
    dailyPLmtm = dpm;
    dailyPLtheo = dpt;
    }

    public TabFormVars(String p, String s, String t, Integer a, String c, Integer st, Date e, BigDecimal ppr, BigDecimal cpr, BigDecimal ppm, BigDecimal cpm, BigDecimal pt, BigDecimal ct, BigDecimal dpm, BigDecimal dpt) {
        posid = p;
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
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public BigDecimal getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(BigDecimal prevPrice) {
        this.prevPrice = prevPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getPrevPrem() {
        return prevPrem;
    }

    public void setPrevPrem(BigDecimal prevPrem) {
        this.prevPrem = prevPrem;
    }

    public BigDecimal getCurrentPrem() {
        return currentPrem;
    }

    public void setCurrentPrem(BigDecimal currentPrem) {
        this.currentPrem = currentPrem;
    }

    public BigDecimal getPrevTheo() {
        return prevTheo;
    }

    public void setPrevTheo(BigDecimal prevTheo) {
        this.prevTheo = prevTheo;
    }

    public BigDecimal getCurrentTheo() {
        return currentTheo;
    }

    public void setCurrentTheo(BigDecimal currentTheo) {
        this.currentTheo = currentTheo;
    }

    public BigDecimal getDailyPLmtm() {
        return dailyPLmtm;
    }

    public void setDailyPLmtm(BigDecimal dailyPLmtm) {
        this.dailyPLmtm = dailyPLmtm;
    }

    public BigDecimal getDailyPLtheo() {
        return dailyPLtheo;
    }

    public void setDailyPLtheo(BigDecimal dailyPLtheo) {
        this.dailyPLtheo = dailyPLtheo;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    public BigDecimal getTradePrem() {
        return tradePrem;
    }

    public void setTradePrem(BigDecimal tradePrem) {
        this.tradePrem = tradePrem;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    @Override
    public int compareTo(TabFormVars p2) {
        return symbol.compareTo(p2.getSymbol());
    }
}
