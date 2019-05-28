package com.unicom.salesmanagebehind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="管理员信息")
public class Manager {
    @ApiModelProperty(value="管理员id",name="managerId",required=true)
    private int managerId;

    @ApiModelProperty(value="管理员姓名",name="managerName",required=true)
    private String managerName;

    @ApiModelProperty(value="登录账户名",name="loginName",required=true)
    private String loginName;

    @ApiModelProperty(value="管理员性别",name="managerSex",required=true)
    private String managerSex;

    @ApiModelProperty(value="登录密码",name="password",required=true)
    private String password;

    @ApiModelProperty(value="管理员手机号",name="managerTel",required=true)
    private String managerTel;

    @ApiModelProperty(value="管理员邮箱",name="managerEmail",required=true)
    private String managerEmail;

//    @ApiModelProperty(value="月销售id",name="role",required=true)
    private int role;

    @ApiModelProperty(value="是否已被删除",name="isDelete",required=true)
    private int isDelete;
    @ApiModelProperty(value="当前用户登录token(唯一)",name="token",required=true)
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getManagerSex() {
        return managerSex;
    }

    public void setManagerSex(String managerSex) {
        this.managerSex = managerSex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Manager() {
    }

    public Manager(int managerId, String managerName, String loginName, String managerSex, String password, String managerTel, String managerEmail, int role, int isDelete, String token) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.loginName = loginName;
        this.managerSex = managerSex;
        this.password = password;
        this.managerTel = managerTel;
        this.managerEmail = managerEmail;
        this.role = role;
        this.isDelete = isDelete;
        this.token = token;
    }
}