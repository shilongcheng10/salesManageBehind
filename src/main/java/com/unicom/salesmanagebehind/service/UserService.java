package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList(String userName,String productName,String tel,Integer fee,Integer onlineTime);
}
