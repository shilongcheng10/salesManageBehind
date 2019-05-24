package com.unicom.salesmanagebehind.model;

public class Saleman {
    private int saleId;

    private String saleName;

    private int saleSex;

    private String saleTelNum;

    private String commision;

    private int saleProductNum;

    private int saleTotalPrice;

    private int isDelete;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public int getSaleSex() {
        return saleSex;
    }

    public void setSaleSex(int saleSex) {
        this.saleSex = saleSex;
    }

    public String getSaleTelNum() {
        return saleTelNum;
    }

    public void setSaleTelNum(String saleTelNum) {
        this.saleTelNum = saleTelNum;
    }

    public String getCommision() {
        return commision;
    }

    public void setCommision(String commision) {
        this.commision = commision;
    }

    public int getSaleProductNum() {
        return saleProductNum;
    }

    public void setSaleProductNum(int saleProductNum) {
        this.saleProductNum = saleProductNum;
    }

    public int getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(int saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Saleman(){
    }

    public Saleman(int saleId, String saleName, int saleSex, String saleTelNum, String commision, int saleProductNum, int saleTotalPrice, int isDelete) {
        this.saleId = saleId;
        this.saleName = saleName;
        this.saleSex = saleSex;
        this.saleTelNum = saleTelNum;
        this.commision = commision;
        this.saleProductNum = saleProductNum;
        this.saleTotalPrice = saleTotalPrice;
        this.isDelete = isDelete;
    }
}
