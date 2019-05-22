package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.Saleman;

import java.util.List;

public interface SalemanService {

    List<Saleman> getAllSaleman();

    int deleteByPrimaryKey(int saleId);

    int insert(Saleman record);

}

