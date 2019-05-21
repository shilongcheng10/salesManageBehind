package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface ManagerDao {

//    @Select("select * from manager")
    List<Manager> getList();

    int deleteByPrimaryKey(int managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(int managerId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}