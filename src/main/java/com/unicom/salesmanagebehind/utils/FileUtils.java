package com.unicom.salesmanagebehind.utils;

import com.unicom.salesmanagebehind.model.ResultPojo;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: saleManage
 * @description: 文件操作公共类
 * @author: Shilongcheng
 * @create: 2019-05-22 21:11
 **/
public class FileUtils {
    
    public static ResultPojo upload(MultipartFile file){
        //获取文件在服务器的储存位置
        if (file.isEmpty()) {
            return ResultUtils.error(-1,"上传失败，请选择文件");
        }
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/upload/";
        File folder = new File(path);
        System.out.println("文件的保存路径：" + path);

        if (!folder.exists() && !folder.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + folder);
            folder.mkdirs();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = file.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        String newName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
        File newFile = new File(path + newName);
        System.out.println("新文件名称：" + newFile);


        //将文件保存到服务器指定位置
        try {
            file.transferTo(newFile);
            System.out.println("上传成功");
            System.out.println(newName);
            //将文件在服务器的存储路径返回
            return ResultUtils.success("上传成功","/upload/" + newName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return ResultUtils.error(-2, "上传失败");
        }
    }

    public static ResultPojo delete(String relativeFilePath){
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static";
        File file=new File(path+relativeFilePath);
        if(!file.exists()){
            System.out.println("文件" + relativeFilePath + "不存在");
            return ResultUtils.error(-1,"文件不存在！");
        }
        if (file.delete()){
            return ResultUtils.success("删除成功！");
        }else{
            return ResultUtils.error(-2,"删除失败！");
        }



    }
}
