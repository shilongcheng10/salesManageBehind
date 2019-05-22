package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Saleman;

import java.util.List;

public interface SalemanDao {

    List<Saleman> getAllSaleman();
    int deleteByPrimaryKey(int saleId);

    int insert(Saleman record);

    int insertSelective(Saleman record);

    Saleman selectByPrimaryKey(int saleId);

    int updateByPrimaryKeySelective(Saleman record);

    int updateByPrimaryKey(Saleman record);
}