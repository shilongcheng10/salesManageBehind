package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.Manager;

import java.util.List;


public interface ManagerService {

    List<Manager> getList();

    int add();


}
