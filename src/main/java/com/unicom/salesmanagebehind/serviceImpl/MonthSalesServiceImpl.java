package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.MonthSalesDao;
import com.unicom.salesmanagebehind.model.MonthSale;
import com.unicom.salesmanagebehind.service.MonthSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: saleManage
 * @description: 月销售接口实现
 * @author: XiongMing
 * @create: 2019-05-24 13:52
 **/
@Service
public class MonthSalesServiceImpl  implements MonthSalesService {
    @Autowired
    private MonthSalesDao monthSalesDao;

    @Override
    public List<MonthSale> getSales() {
        return monthSalesDao.getSales();
    }
}
