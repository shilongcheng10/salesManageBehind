package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.Manager;

import java.util.List;


public interface PersonalService {

    List<Manager> getList(Integer managerId,String managerName,String loginName,String managerSex,String managerEmail,String managerTel);

    int update(Manager manager);



}
