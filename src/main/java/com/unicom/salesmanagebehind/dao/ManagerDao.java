
package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ManagerDao {

    //    @Select("select * from manager")
    List<Manager> getList(@Param("managerId")Integer managerId,@Param("managerName")String managerName, @Param("loginName")String loginName,@Param("managerTel") String managerTel);

    int addManager(Manager manager);

    int update(Manager manager);

    int delete(Integer id);

    int deleteAll(List list);

    int deleteByPrimaryKey(int managerId);

    int insert(Manager record);

    int insertSelective(Manager record);
}