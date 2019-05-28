package com.unicom.salesmanagebehind.controller;

import com.unicom.salesmanagebehind.model.*;
import com.unicom.salesmanagebehind.service.MonthSalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "触点营销后台管理系统-月销售报表")
@RestController
@RequestMapping(value = "MonthSale")
public class MonthSalesController {
    @Autowired
    private MonthSalesService monthSalesService;
    @RequestMapping(value="list")
    @ApiOperation(value = "获取月销售数据")
    @ApiImplicitParam(name = "monthSale",value="月销售数据",required = true,dataType = "List")
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
            int a=list.get(i).getSaleVolume()-list.get(i-1).getSaleVolume();
            list.get(i).setMonthDifference(a);
        }

        return new JSONResult().ok(list);
    }

}
