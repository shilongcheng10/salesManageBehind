package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getUserList();

    int deleteByPrimaryKey(int userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}