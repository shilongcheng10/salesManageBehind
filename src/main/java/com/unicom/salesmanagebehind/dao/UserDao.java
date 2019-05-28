package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getUserList(@Param("userName") String userName,@Param("productName") String productName,@Param("tel") String tel,@Param("fee") Integer fee,@Param("onlineTime") Integer onlineTime);

    int deleteByPrimaryKey(int userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}