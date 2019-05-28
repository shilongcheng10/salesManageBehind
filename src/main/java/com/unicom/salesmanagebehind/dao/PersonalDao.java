package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PersonalDao {

    Manager getManagerInfoByToken(String token);

    void updateManagerInfoByToken(Manager manager);
//    String update(Manager manager);



}