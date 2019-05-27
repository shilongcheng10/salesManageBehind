package com.unicom.salesmanagebehind.service;


import com.unicom.salesmanagebehind.model.Product;
import com.unicom.salesmanagebehind.model.Saleman;

import java.util.List;


public interface DashboardService {
    //查询当日销售额
    int selectDay();

    //查询当月销售额
    int selectMonth();

    //查询本年销售额
    int selectYear();

    //套餐统计
    List<Product> selectProduct();

    //营销人员统计
    List<Saleman> selectSaleMan();
}
