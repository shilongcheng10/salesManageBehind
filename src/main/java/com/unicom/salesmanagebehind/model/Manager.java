package com.unicom.salesmanagebehind.model;

public class Manager {
    private int managerId;

    private String managerName;

    private String loginName;

    private String managerSex;

    private String password;

    private String managerTel;

    private String managerEmail;

    private int role;

    private int isDelete;
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

    public Manager(int managerId, String managerName, String loginName, String managerSex, String password, String managerTel, String managerEmail, int role, int isDelete) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.loginName = loginName;
        this.managerSex = managerSex;
        this.password = password;
        this.managerTel = managerTel;
        this.managerEmail = managerEmail;
        this.role = role;
        this.isDelete = isDelete;
    }
}