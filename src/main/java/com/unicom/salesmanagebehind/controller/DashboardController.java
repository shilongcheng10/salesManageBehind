package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;



}
