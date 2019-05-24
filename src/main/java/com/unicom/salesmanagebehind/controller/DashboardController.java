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
        list.set(1,dashboardService.selectDay());
        list.set(2,dashboardService.selectMonth());
        list.set(3,dashboardService.selectYear());
        return new JSONResult().ok(list);
    }



}
