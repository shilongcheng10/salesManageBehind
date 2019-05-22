package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Product;

public interface ProductDao {
    int deleteByPrimaryKey(int productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(int productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}