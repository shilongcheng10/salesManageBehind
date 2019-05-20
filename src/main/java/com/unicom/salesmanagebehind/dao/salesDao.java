package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Sales;

public interface salesDao {
    int deleteByPrimaryKey(int saleId);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(int saleId);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
}