package com.unicom.salesmanagebehind.model;

import java.util.Date;

public class Sales {
    private int saleId;

    private int salemanId;

    private int productId;

    private Date date;

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