package com.unicom.salesmanagebehind.model;

import java.util.Date;


public class Product {
    private int productId;

    private String productName;

    private int productFee;

    private String recommend;

    private String description;

    private int isFirstPush;

    private Date startTime;

    private Date endTime;

    private String updateUser;

    private Date updateTime;

    private String imgUrl;

    private int isDelete;

    private int salesCount;
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductFee() {
        return productFee;
    }

    public void setProductFee(int productFee) {
        this.productFee = productFee;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsFirstPush() {
        return isFirstPush;
    }

    public void setIsFirstPush(int isFirstPush) {
        this.isFirstPush = isFirstPush;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }



    public Product() {
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public Product(int productId, String productName, int productFee, String recommend, String description, int isFirstPush, Date startTime, Date endTime, String updateUser, Date updateTime, String imgUrl, int isDelete, int salesCount) {
        this.productId = productId;
        this.productName = productName;
        this.productFee = productFee;
        this.recommend = recommend;
        this.description = description;
        this.isFirstPush = isFirstPush;
        this.startTime = startTime;
        this.endTime = endTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.imgUrl = imgUrl;
        this.isDelete = isDelete;
        this.salesCount = salesCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productFee=" + productFee +
                ", recommend='" + recommend + '\'' +
                ", description='" + description + '\'' +
                ", isFirstPush=" + isFirstPush +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", imgUrl='" + imgUrl + '\'' +
                ", isDelete=" + isDelete +
                ", salesCount=" + salesCount +
                '}';
    }
}