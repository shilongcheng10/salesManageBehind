package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.PersonalService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = {"触点营销后台管理系统-个人信息修改模块"})
@RestController
@RequestMapping(value = "personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @ApiOperation(value = "获取当前管理员用户的信息")
    @ApiImplicitParam(name ="token",value = "当前管理员登录的token",required = true,dataType = "String")
    @GetMapping(value = "/getInfo")
    public ResultPojo getManagerInfo(@RequestParam(name = "token") String token) {
        if (token != null && !token.equals("")) {
            Manager manager = personalService.getManagerInfo(token);
            if (manager != null) {
                return ResultUtils.success(manager);
            } else {
                return ResultUtils.error(-1, "获取用户信息失败");
            }
        }
        return null;
    }

    @ApiOperation(value = "当前管理员用户信息更新")
    @ApiImplicitParam(name ="manager",value = "前端传输过来的更新的管理员信息",required = true,dataType = "Manager")
    @PostMapping (value = "/putInfo")
    public ResultPojo updateManagerInfo(@RequestBody Manager manager) {
        if (manager.getToken() != null && !manager.getToken().equals("")) {
            manager.setToken(manager.getToken());
          personalService.updateManagerInfo(manager);
//            personalService.updateManagerInfo(manager);
                return getManagerInfo(manager.getToken());
        }
        return null;
    }


}