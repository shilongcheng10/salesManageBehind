package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.Manager;

import java.util.List;


public interface ManagerService {

    Manager isLoginSuccess(Manager manager);

    List<Manager> getList(Integer managerId,String managerName,String loginName,String managerTel);

    int add(Manager manager);

    int update(Manager manager);

    int delete(Integer id);

    int deleteAll(List list);

    String getLoginNameByToken(String token);

    void updateTokenById(Manager manager);


    String getTokenById(int id);

    Manager getUserInfoByToken(String token);

    void logout(String token);
}
