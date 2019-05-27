package com.unicom.salesmanagebehind.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DashboardDao {

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
