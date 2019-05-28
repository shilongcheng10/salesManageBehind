package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.UserDao;
import com.unicom.salesmanagebehind.model.User;
import com.unicom.salesmanagebehind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList(String userName,String productName,String tel,Integer fee,Integer onlineTime) {
        return userDao.getUserList(userName,productName,tel,fee,onlineTime);
    }
}
