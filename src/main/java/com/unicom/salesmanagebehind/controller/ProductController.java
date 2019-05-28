package com.unicom.salesmanagebehind.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unicom.salesmanagebehind.model.Product;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.ManagerService;
import com.unicom.salesmanagebehind.service.ProductService;
import com.unicom.salesmanagebehind.utils.DateUtil;
import com.unicom.salesmanagebehind.utils.FileUtils;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
/**
 * @program: saleManage
 * @description: 套餐列表Controller
 * @author: Shilongcheng
 * @create: 2019-05-21 10:12
 **/
@Api(tags = {"触点营销后台管理系统-套餐管理模块"})
@RestController
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Value("${app.ip}")
    private String ipaddress;
    @Autowired
    private ManagerService managerService;


    @ApiOperation(value = "添加套餐信息")
    @ApiImplicitParam(name = "product",value="套餐数据",required = true,dataType = "Product")
    @Transactional
    @RequestMapping(value="add",method = RequestMethod.POST)
    public ResultPojo addProduct(@RequestBody Product product){
        System.out.println(product);

        String token=product.getUpdateUser();
        String updateUser=managerService.getLoginNameByToken(token);
        if (updateUser!=null&&!updateUser.isEmpty()){
            product.setUpdateUser(updateUser);
        }
        if (productService.insertItem(product)!=1){
            return ResultUtils.error(-1,"插入失败");
        }
        product.setImgUrl(ipaddress+product.getImgUrl());
        product.setUpdateTime(new Date());
        return ResultUtils.success("插入成功",product);
    }

    @ApiOperation(value = "套餐图片上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "picture",value="套餐图片",required = true,dataType = "MultipartFile"),
            @ApiImplicitParam(name = "request",value = "前端request请求",required = true,dataType = "HttpServletRequest")})
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public ResultPojo uploadImg(MultipartFile picture, HttpServletRequest request){
        return FileUtils.upload(picture);
    }

    @ApiOperation(value = "获取套餐列表信息")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultPojo getList(){
        List<Product> list=productService.getList();
        if (list==null){
            return ResultUtils.error(-1,"没有套餐列表相关记录");
        }
        for (Product item:list) {
            item.setImgUrl(ipaddress+item.getImgUrl());
        }
        return ResultUtils.success("获得列表成功",list);
    }

    @ApiOperation(value = "更新套餐信息")
    @ApiImplicitParam(name = "product",value = "等待更新的套餐信息",required = true,dataType = "Product")
    @Transactional
    @RequestMapping(value="update",method = RequestMethod.POST)
    public ResultPojo editProduct(@RequestBody Product product){
        String imgUrl = product.getImgUrl();
        if (!imgUrl.contains("http")){
            String filePath=productService.getImgSrcById(product.getProductId());
            ResultPojo resultPojo=FileUtils.delete(filePath);
            if (resultPojo.getCode()!=0){
                return ResultUtils.error(-2,"图片更新失败");
            }
            product.setImgUrl(imgUrl);
        }
        String token=product.getUpdateUser();
        String updateUser=managerService.getLoginNameByToken(token).trim();
        if (updateUser!=null&&!updateUser.isEmpty()){
            product.setUpdateUser(updateUser);
        }else{
            return ResultUtils.error(-3,"获取当前用户信息失败");
        }
        try{
            productService.update(product);

            return ResultUtils.success("更新成功",ipaddress+imgUrl);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(-1,"更新失败");
        }

    }

    @ApiOperation(value = "获取套餐详情")
    @ApiImplicitParam(name ="params",value = "套餐相关的参数",required = true,dataType = "String")
    @RequestMapping(value="detail",method = RequestMethod.GET)
    public ResultPojo getItemInfo(@RequestParam String params){
        JSONObject jsonObject = JSONObject.parseObject(params);
        int id=(int)jsonObject.get("id");
        Product product=productService.getItemInfo(id);
        if (product==null){
            return ResultUtils.error(-1,"获得套餐详情失败");
        }
        System.out.println(product);
        return ResultUtils.success("获得套餐详情成功！",product);

    }

    @ApiOperation(value = "设置该套餐为首推套餐")
    @ApiImplicitParam(name ="params",value = "套餐相关的参数",required = true,dataType = "String")
    @Transactional
    @RequestMapping(value="setFirstPush",method = RequestMethod.PUT)
    public ResultPojo setFirstPush(@RequestParam String params){
        JSONObject jsonObject = JSONObject.parseObject(params);
        int id = (int)jsonObject.get("id");
        Product product = new Product();
        product.setProductId(id);
        product.setIsFirstPush(1);
        try {
            productService.update(product);
            if ( productService.setNotFirstPush(id)== 0){
                return ResultUtils.success("设置首推成功");
            }else{
                return ResultUtils.error(-1,"设置首推失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(-2,e.getMessage());
        }
    }

    @ApiOperation(value = "删除套餐信息")
    @ApiImplicitParam(name ="params",value = "套餐相关的参数",required = true,dataType = "String")
    @Transactional
    @RequestMapping(value="delete",method = RequestMethod.PUT)
    public ResultPojo deleteItem(@RequestParam String params){
        JSONObject jsonObject = JSONObject.parseObject(params);
        int id = (int)jsonObject.get("id");
        Product product = new Product();
        product.setProductId(id);
        product.setIsDelete(1);
        try {
            productService.update(product);
            return ResultUtils.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtils.error(-1,"删除失败");
        }
    }

}

