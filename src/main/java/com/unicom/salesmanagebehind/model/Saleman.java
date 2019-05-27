package com.unicom.salesmanagebehind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="销售人员实体对象")
public class Saleman {
    @ApiModelProperty(value="销售人员id",name="saleId",required=true)
    private int saleId;

    @ApiModelProperty(value="销售人员姓名",name="saleName",required=true)
    private String saleName;

    @ApiModelProperty(value="销售人员性别",name="saleSex",required=true)
    private int saleSex;

    @ApiModelProperty(value="销售人员手机号",name="saleTelNum",required=true)
    private String saleTelNum;


    @ApiModelProperty(value="销售记录id",name="saleProductNum",required=true)
    private int saleProductNum;

    @ApiModelProperty(value="销售人员销售总利润",name="saleTotalPrice",required=true)
    private int saleTotalPrice;

    @ApiModelProperty(value="销售人员是否删除标志",name="isDelete",required=true)
    private int isDelete;


    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }


    public Saleman(){
    }

    public Saleman(int saleId, String saleName, int saleSex, String saleTelNum, int saleProductNum, int saleTotalPrice, int isDelete) {
        this.saleId = saleId;
        this.saleName = saleName;
        this.saleSex = saleSex;
        this.saleTelNum = saleTelNum;
        this.isDelete = isDelete;
        this.saleProductNum=saleProductNum;
        this.saleTotalPrice=saleTotalPrice;

    }
}
