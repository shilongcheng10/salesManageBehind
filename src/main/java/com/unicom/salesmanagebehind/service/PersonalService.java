package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.Manager;

import java.util.List;


public interface PersonalService {

    Manager getManagerInfo(String token);
    void updateManagerInfo(Manager manager);

//    String update(Manager manager);


}
