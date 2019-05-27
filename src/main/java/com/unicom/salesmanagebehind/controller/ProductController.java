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
@RestController
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Value("${app.ip}")
    private String ipaddress;
    @Autowired
    private ManagerService managerService;


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


    @RequestMapping(value = "upload")
    public ResultPojo uploadImg(MultipartFile picture, HttpServletRequest request){
        return FileUtils.upload(picture);
    }

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

