package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.model.Saleman;
import com.unicom.salesmanagebehind.service.SalemanService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "saleman")
public class SalemanController {
    @Autowired SalemanService salemanService;
    @RequestMapping("/getAll")
    public ResultPojo getList(){
        List<Saleman> list =salemanService.getAllSaleman();
        return ResultUtils.success(list);
    }

    @RequestMapping(value = "delete")
    public ResultPojo delete(@RequestParam (name = "saleId") int saleId){
        salemanService.deleteByPrimaryKey(saleId);
        return ResultUtils.success();
    }
}
