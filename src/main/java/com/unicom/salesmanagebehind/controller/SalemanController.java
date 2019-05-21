package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.Saleman;
import com.unicom.salesmanagebehind.service.SalemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "saleman")
public class SalemanController {
    @Autowired SalemanService salemanService;
    @RequestMapping("/getAll")
    public List<Saleman> getList(){
        List<Saleman> list =salemanService.getAllSaleman();
        return list;
    }
}
