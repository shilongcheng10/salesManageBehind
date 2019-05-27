package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.DashboardDao;
import com.unicom.salesmanagebehind.dao.ProductDao;
import com.unicom.salesmanagebehind.model.Product;
import com.unicom.salesmanagebehind.model.Saleman;
import com.unicom.salesmanagebehind.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardDao dashboardDao;
    private ProductDao productDao;

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
    public List<Product> selectProduct(){
        return dashboardDao.selectProduct();
    }

    //营销人员统计
    public List<Saleman> selectSaleMan(){
        return dashboardDao.selectSaleMan();
    }

}
