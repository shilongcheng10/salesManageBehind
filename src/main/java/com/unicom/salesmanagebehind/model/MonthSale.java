package com.unicom.salesmanagebehind.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MonthSale {
    private String saleMonthId;
    @JsonFormat(pattern = "yyyy-MM",locale = "zh",timezone = "GMT+8")
    private Date saleMonth;
    private int saleVolume;
    private int saleCount;
    private int monthDifference;

    public String getSaleMonthId() {
        return saleMonthId;
    }

    public void setSaleMonthId(String saleMonthId) {
        this.saleMonthId = saleMonthId;
    }

    public Date getSaleMonth() {
        return saleMonth;
    }

    public void setSaleMonth(Date saleMonth) {
        this.saleMonth = saleMonth;
    }

    public int getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(int saleVolume) {
        this.saleVolume = saleVolume;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getMonthDifference() {
        return monthDifference;
    }

    public void setMonthDifference(int monthDifference) {
        this.monthDifference = monthDifference;
    }

    public MonthSale() {
    }

    public MonthSale(String saleMonthId, Date saleMonth, int saleVolume, int saleCount, int monthDifference) {
        this.saleMonthId = saleMonthId;
        this.saleMonth = saleMonth;
        this.saleVolume = saleVolume;
        this.saleCount = saleCount;
        this.monthDifference = monthDifference;
    }
}
