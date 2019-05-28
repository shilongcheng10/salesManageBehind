package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.PersonalService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;


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