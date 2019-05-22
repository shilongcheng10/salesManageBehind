package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.DashboardDao;
import com.unicom.salesmanagebehind.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardDao dashboardDao;

    //查询当日销售额
    public int selectDay(){
       return dashboardDao.selectDay();
    }

    //查询当月销售额
    public int selectMonth(){
        return dashboardDao.selectMonth();
    }

    //查询本年销售额
    public int selectYear(){
        return dashboardDao.selectYear();
    }

    //套餐统计
    public List selectProduct(){
        return dashboardDao.selectProduct();
    }

    //营销人员统计
    public List selectSaleMan(){
        return dashboardDao.selectSaleMan();
    }

}
