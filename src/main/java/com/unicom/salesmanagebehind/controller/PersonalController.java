package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping(value = "/list")
    public JSONResult selectList(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "2") int limit,
            @RequestParam(name = "managerId",defaultValue ="") Integer managerId,
            @RequestParam(name = "managerName",defaultValue = "") String managerName,
            @RequestParam(name = "loginName",defaultValue = "") String loginName,
            @RequestParam(name = "managerSex",defaultValue = "") String managerSex,
            @RequestParam(name = "managerEmail",defaultValue = "") String managerEmail,
            @RequestParam(name = "managerTel",defaultValue = "") String managerTel
    ) {
        PageHelper.startPage(page,limit);

        List<Manager> list = personalService.getList(managerId,managerName,loginName,managerSex,managerEmail,managerTel);

        PageInfo<Manager> pageInfo =new PageInfo<>(list);

        return new JSONResult().ok(pageInfo);
    }

    @PutMapping(value = "/update")
    public JSONResult update(@RequestBody Manager manager){
        personalService.update(manager);

        return new JSONResult().ok("success");
    }


}