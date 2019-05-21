package com.unicom.salesmanagebehind.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unicom.salesmanagebehind.model.Product;
import org.springframework.web.bind.annotation.*;

/**
 * @program: saleManage
 * @description: 套餐列表Controller
 * @author: Shilongcheng
 * @create: 2019-05-21 10:12
 **/
@RestController
@RequestMapping(value = "product")
public class productController {
    @RequestMapping(value="add",method = RequestMethod.POST)
    public Product addProduct(@RequestParam String params){
//        System.out.println(product);
        JSONObject json=JSON.parseObject(params);
        String imgUrl=json.get("img").toString();
        System.out.println(imgUrl);
        return null;
    }
}
