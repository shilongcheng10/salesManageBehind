package com.unicom.salesmanagebehind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description="套餐信息数据")
public class Product {
    @ApiModelProperty(value="套餐id",name="productId",required=true)
    private int productId;

    @ApiModelProperty(value="套餐名称",name="productName",required=true)
    private String productName;

    @ApiModelProperty(value="套餐资费",name="productFee",required=true)
    private int productFee;

    @ApiModelProperty(value="套餐简介",name="recommend",required=true)
    private String recommend;

    @ApiModelProperty(value="套餐详细描述",name="description",required=true)
    private String description;

    @ApiModelProperty(value="是否首推套餐",name="isFirstPush",required=true)
    private int isFirstPush;

    @ApiModelProperty(value="套餐生效时间",name="startTime",required=true)
    private Date startTime;

    @ApiModelProperty(value="套餐失效时间",name="endTime",required=true)
    private Date endTime;

    @ApiModelProperty(value="套餐信息最近更新人",name="updateUser",required=true)
    private String updateUser;

    @ApiModelProperty(value="套餐最近更新时间",name="updateTime",required=true)
    private Date updateTime;

    @ApiModelProperty(value="套餐图片路径",name="imgUrl",required=true)
    private String imgUrl;

    @ApiModelProperty(value="套餐是否被删除标志",name="isDelete",required=true)
    private int isDelete;

    @ApiModelProperty(value="该套餐历史销售数量",name="salesCount",required=true)
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