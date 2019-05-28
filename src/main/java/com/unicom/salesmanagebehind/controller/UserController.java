package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.User;
import com.unicom.salesmanagebehind.service.UserService;
import com.unicom.salesmanagebehind.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

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
