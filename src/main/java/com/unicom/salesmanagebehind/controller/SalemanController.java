package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.model.Saleman;
import com.unicom.salesmanagebehind.service.SalemanService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "saleman")
public class SalemanController {
    @Autowired SalemanService salemanService;
    @RequestMapping("/getAll")
    public JSONResult getList(){
        List<Saleman> list =salemanService.getAllSaleman();
        return new JSONResult().ok(list);
    }

    @RequestMapping(value = "delete")
    public ResultPojo delete(@RequestParam (name = "saleId") int id){
        salemanService.deleteByPrimaryKey(id);
        return ResultUtils.success();
    }

    @RequestMapping(value = "insert")
    public  ResultPojo insert(
            @Valid Saleman record
//            @RequestParam(name = "saleName") String saleName,
//            @RequestParam(name = "saleSex") int saleSex,
//            @RequestParam(name = "saleTelNum") String saleTelNum,
//            @RequestParam(name = "commision") String commision,
//            @RequestParam(name = "saleProductNum") int saleProductNum,
//            @RequestParam(name = "saleTotalPrice") int saleTotalPrice
    ){
        salemanService.insert(record);
        return ResultUtils.success();

    }
}
