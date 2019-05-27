package com.unicom.salesmanagebehind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description="销售数据实体对象")
public class Sales {
    @ApiModelProperty(value="销售记录id",name="saleId",required=true)
    private int saleId;

    @ApiModelProperty(value="销售人员id",name="salemanId",required=true)
    private int salemanId;

    @ApiModelProperty(value="销售出的套餐id",name="productId",required=true)
    private int productId;

    @ApiModelProperty(value="销售日期",name="date",required=true)
    private Date date;

    @ApiModelProperty(value="销售地区",name="address",required=true)
    private String address;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getSalemanId() {
        return salemanId;
    }

    public void setSalemanId(int salemanId) {
        this.salemanId = salemanId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}