package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "/list")
    public JSONResult selectList() {
        List<Manager> list = managerService.getList();
        return new JSONResult().ok(list);
    }
}
