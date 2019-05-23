package com.unicom.salesmanagebehind.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unicom.salesmanagebehind.model.Product;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.ProductService;
import com.unicom.salesmanagebehind.utils.DateUtil;
import com.unicom.salesmanagebehind.utils.FileUtils;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
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

    @RequestMapping(value="add",method = RequestMethod.POST)
    public ResultPojo addProduct(@RequestParam String params){
        System.out.println(params);
//        System.out.println(product);
        JSONObject json=JSON.parseObject(params);
        Product product = new Product();
        product.setProductName(json.get("productName").toString());
        product.setProductFee((int)json.get("productFee"));
        product.setStartTime(DateUtil.parseDate(json.get("startTime").toString()));
        product.setEndTime(DateUtil.parseDate(json.get("endTime").toString()));
        product.setDescription(json.get("description").toString());
        if (json.get("imgUrl")!=null){
            product.setImgUrl(json.get("imgUrl").toString());

        }else {
            product.setImgUrl("");
        }
        product.setUpdateUser(json.get("updateUser").toString());
        product.setRecommend(json.get("recommend").toString());
        if (productService.insertItem(product)!=1){
            return ResultUtils.error(-1,"插入失败");
        }
        System.out.println(product);
        product.setImgUrl("http://localhost:8080"+json.get("imgUrl").toString());
        product.setUpdateTime(new Date());
        return ResultUtils.success("插入成功",product);
    }
    @RequestMapping(value = "upload")
    public ResultPojo uploadImg(MultipartFile picture, HttpServletRequest request){
        return FileUtils.upload(picture);
//        //获取文件在服务器的储存位置
//        if (picture.isEmpty()) {
//            return ResultUtils.error(-1,"上传失败，请选择文件");
//        }
//        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/upload/";
//        File folder = new File(path);
//        System.out.println("文件的保存路径：" + path);
//
//        if (!folder.exists() && !folder.isDirectory()) {
//            System.out.println("目录不存在，创建目录:" + folder);
//            folder.mkdirs();
//        }
//
//        //获取原始文件名称(包含格式)
//        String originalFileName = picture.getOriginalFilename();
//        System.out.println("原始文件名称：" + originalFileName);
//
//        //获取文件类型，以最后一个`.`为标识
//        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//        System.out.println("文件类型：" + type);
//
//        //设置文件新名称: 当前时间+文件名称（不包含格式）
//        String newName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
//        File newFile = new File(path + newName);
//        System.out.println("新文件名称：" + newFile);
//
//
//        //将文件保存到服务器指定位置
//        try {
//            picture.transferTo(newFile);
//            System.out.println("上传成功");
//            System.out.println(newName);
//            //将文件在服务器的存储路径返回
//            return ResultUtils.success("上传成功","/upload/" + newName);
//        } catch (IOException e) {
//            System.out.println("上传失败");
//            e.printStackTrace();
//            return ResultUtils.error(-2, "上传失败");
//        }
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultPojo getList(){
        List<Product> list=productService.getList();
        if (list==null){
            return ResultUtils.error(-1,"没有套餐列表相关记录");
        }
        for (Product item:list) {
            item.setImgUrl("http://localhost:8080"+item.getImgUrl());
        }
        return ResultUtils.success("获得列表成功",list);
    }
    @RequestMapping(value="update",method = RequestMethod.POST)
    public ResultPojo editProduct(@RequestParam String params){
        JSONObject json=JSON.parseObject(params);
        System.out.println(json.toString());
        Product product = new Product();
        product.setProductId((int)json.get("productId"));
        product.setProductName(json.get("productName").toString());
        product.setProductFee((int)json.get("productFee"));
        product.setStartTime(DateUtil.parseDate(json.get("startTime").toString()));
        product.setEndTime(DateUtil.parseDate(json.get("endTime").toString()));
        product.setDescription(json.get("description").toString());
        product.setRecommend(json.get("recommend").toString());
        String imgUrl = json.get("imgUrl").toString();
        if (!imgUrl.contains("http")){
            product.setImgUrl(imgUrl);
        }else{

        }
        product.setUpdateUser(json.get("updateUser").toString());
        try{
            productService.update(product);
                return ResultUtils.success("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(-1,"更新失败");
        }

    }
}

