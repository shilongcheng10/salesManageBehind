package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.User;

public interface userDao {
    int deleteByPrimaryKey(int userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}