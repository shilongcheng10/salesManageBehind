package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.service.DashboardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"触点营销后台管理系统-首页数据展示"})
@RestController
@RequestMapping(value = "dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/moneyList")
    public JSONResult showMoney(){ //日/月/年 销售额
        List<Integer> list = new ArrayList();
        list.add(dashboardService.selectDay());
        list.add(dashboardService.selectMonth());
        list.add(dashboardService.selectYear());
        return new JSONResult().ok(list);
    }

    @GetMapping(value = "/productList")
    public JSONResult showProduct(){ //热销套餐
        return new JSONResult().ok(dashboardService.selectProduct());
    }

    @GetMapping(value = "/saleManList")
    public JSONResult showSaleMan(){ //销售精英
        return new JSONResult().ok(dashboardService.selectSaleMan());
    }
}
