package com.unicom.salesmanagebehind.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardService {
    //查询当日销售额
    int selectDay();

    //查询当月销售额
    int selectMonth();

    //查询本年销售额
    int selectYear();

    //套餐统计
    List selectProduct();

    //营销人员统计
    List selectSaleMan();
}
