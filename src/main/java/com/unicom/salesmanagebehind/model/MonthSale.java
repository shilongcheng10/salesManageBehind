package com.unicom.salesmanagebehind.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description="月销售信息")
public class MonthSale {
    @ApiModelProperty(value="月销售id",name="saleMonthId",required=true)
    private String saleMonthId;

    @ApiModelProperty(value="销售月份",name="saleMonth",required=true)
    @JsonFormat(pattern = "yyyy-MM",locale = "zh",timezone = "GMT+8")
    private Date saleMonth;

    @ApiModelProperty(value="月销售金额",name="saleVolume",required=true)
    private int saleVolume;

    @ApiModelProperty(value="月销售数量",name="saleCount",required=true)
    private int saleCount;

    @ApiModelProperty(value="较上月销售差额",name="monthDifference",required=true)
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
