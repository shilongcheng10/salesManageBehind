package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Manager;

import java.util.List;

public interface ManagerDao {

    List<Manager> getList();

    int deleteByPrimaryKey(int managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(int managerId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}