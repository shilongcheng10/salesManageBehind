package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.dao.MonthSalesDao;
import com.unicom.salesmanagebehind.model.MonthSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthSalesService {

    @Autowired
    private MonthSalesDao monthSalesDao;
    public List<MonthSale> getSales(){
        return monthSalesDao.getSales();
    }
}
