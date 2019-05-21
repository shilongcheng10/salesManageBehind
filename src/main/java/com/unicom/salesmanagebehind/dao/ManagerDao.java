package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Manager;

public interface ManagerDao {
    int deleteByPrimaryKey(int managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(int managerId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}