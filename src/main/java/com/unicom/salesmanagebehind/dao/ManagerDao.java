
package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository
@Mapper
public interface ManagerDao {

    //    @Select("select * from manager")
    List<Manager> getList();

    int deleteByPrimaryKey(int managerId);

    int insert(Manager record);

    int insertSelective(Manager record);
}
