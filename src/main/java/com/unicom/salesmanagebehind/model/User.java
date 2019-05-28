package com.unicom.salesmanagebehind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description="用户的实体对象")
public class User {
    @ApiModelProperty(value="用户id",name="userId",required=true)
    private int userId;

    @ApiModelProperty(value="用户姓名",name="userName",required=true)
    private String userName;

    @ApiModelProperty(value="用户性别",name="userSex",required=true)
    private int userSex;

    @ApiModelProperty(value="用户年龄",name="userAge",required=true)
    private int userAge;

    @ApiModelProperty(value="用户出生年月",name="birth",required=true)
    private Date birth;

    @ApiModelProperty(value="用户所使用的套餐id",name="productId",required=true)
    private int productId;

    @ApiModelProperty(value="用户的消费情况",name="fee",required=true)
    private int fee;

    @ApiModelProperty(value="用户的手机号码",name="tel",required=true)
    private String tel;

    @ApiModelProperty(value="用户状态",name="status",required=true)
    private String status;

    @ApiModelProperty(value="用户id",name="activeDate",required=true)
    private Date activeDate;

    @ApiModelProperty(value="用户在网时长",name="onlineTime",required=true)
    private int onlineTime;

    @ApiModelProperty(value="用户id",name="isCbss",required=true)
    private int isCbss;

    @ApiModelProperty(value="用户身份证号",name="IDCard",required=true)
    private String IDCard;

    @ApiModelProperty(value="用户身份类型",name="cardType",required=true)
    private String cardType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public int getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(int onlineTime) {
        this.onlineTime = onlineTime;
    }

    public int getIsCbss() {
        return isCbss;
    }

    public void setIsCbss(int isCbss) {
        this.isCbss = isCbss;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}