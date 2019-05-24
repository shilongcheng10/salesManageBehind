package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/moneyList")
    public JSONResult showMoney(){

        List<Integer> list = new ArrayList();
        list.add(dashboardService.selectDay());
        list.add(dashboardService.selectMonth());
        list.add(dashboardService.selectYear());
        return new JSONResult().ok(list);
    }

    @GetMapping(value = "/productList")
    public JSONResult showProduct(){
        return new JSONResult().ok(dashboardService.selectProduct());
    }

}
