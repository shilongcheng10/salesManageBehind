package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Saleman;

public interface salemanDao {
    int deleteByPrimaryKey(int saleId);

    int insert(Saleman record);

    int insertSelective(Saleman record);

    Saleman selectByPrimaryKey(int saleId);

    int updateByPrimaryKeySelective(Saleman record);

    int updateByPrimaryKey(Saleman record);
}