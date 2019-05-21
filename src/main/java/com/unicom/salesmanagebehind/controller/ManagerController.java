package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.service.ManagerService;
import com.unicom.salesmanagebehind.serviceImpl.ManagerServiceImpl;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerServiceImpl managerService;

    @RequestMapping(value = "/list")
    public List<Manager> selectList() {
        List<Manager> list = managerService.getList();
        System.out.println(list);
        return list;
    }
}
