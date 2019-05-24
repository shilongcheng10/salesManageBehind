package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.*;
import com.unicom.salesmanagebehind.service.MonthSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class MonthSalesController {
    @Autowired
    private MonthSalesService monthSalesService;
/*    public ResultPojo get()
    {
        return ResultUtils.success("传输成功",new Product());

    }*/
    @RequestMapping(value="list")
    public JSONResult getMonthSales(){
        List<MonthSale> list= monthSalesService.getSales();

        //添加 编号 列
        for(int i=0;i<list.size();i++){
         Date a =list.get(i).getSaleMonth();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            String dateString = formatter.format(a);
            list.get(i).setSaleMonthId(dateString);
        }
        //添加 月差额 列
        for(int i=1;i<list.size();i++){
            System.out.println(list.get(i).getSaleVolume());
            int a=list.get(i).getSaleVolume()-list.get(i-1).getSaleVolume();
            list.get(i).setMonthDifference(a);
        }

        return new JSONResult().ok(list);
    }

}
