package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.User;
import com.unicom.salesmanagebehind.service.UserService;
import com.unicom.salesmanagebehind.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"触点营销后台管理系统-用户信息模块"})
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required = true,dataType = "string"),
            @ApiImplicitParam(name="limit",value="每页条数",required = true,dataType = "string"),
            @ApiImplicitParam(name="userName",value="用户姓名",required = true,dataType = "string"),
            @ApiImplicitParam(name="productName",value="产品名字",required = true,dataType = "string"),
            @ApiImplicitParam(name="tel",value="手机号码",required = true,dataType = "string"),
            @ApiImplicitParam(name="fee",value="消费金额",required = true,dataType = "int"),
            @ApiImplicitParam(name="onlineTime",value="在网时长",required = true,dataType = "int")
    })
    @GetMapping(value = "/list")
    public JSONResult getUserList(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "10") int limit,
            @RequestParam(name = "userName",defaultValue ="") String userName,
            @RequestParam(name = "productName",defaultValue = "") String productName,
            @RequestParam(name = "tel",defaultValue = "") String tel,
            @RequestParam(name = "fee",defaultValue = "") Integer fee,
            @RequestParam(name = "onlineTime",defaultValue = "") Integer onlineTime
    ){
        PageHelper.startPage(page,limit);

        List<User> list = userService.getUserList(userName,productName,tel,fee,onlineTime);

        PageInfo<User> pageInfo =new PageInfo<>(list);

        return new JSONResult().ok(pageInfo);
    }
}
