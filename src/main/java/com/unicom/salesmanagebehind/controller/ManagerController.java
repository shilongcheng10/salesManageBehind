package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "/list")
    public JSONResult selectList(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "5") int limit,
            @RequestParam(name = "managerId",defaultValue ="") Integer managerId,
            @RequestParam(name = "managerName",defaultValue = "") String managerName,
            @RequestParam(name = "loginName",defaultValue = "") String loginName,
            @RequestParam(name = "managerTel",defaultValue = "") String managerTel
    ) {
        PageHelper.startPage(page,limit);

        List<Manager> list = managerService.getList(managerId,managerName,loginName,managerTel);

        PageInfo<Manager> pageInfo =new PageInfo<>(list);

        return new JSONResult().ok(pageInfo);
    }

    @PostMapping(value = "/add")
    public JSONResult insert(@RequestBody Manager manager){
        int i= managerService.add(manager);

        if (i>0)
            return new JSONResult().ok("success");
        else{
            return null;
        }
    }

    @PutMapping(value = "/update")
    public JSONResult update(@RequestBody Manager manager){
        managerService.update(manager);

        return new JSONResult().ok("success");
    }

    @DeleteMapping(value="/delete")
    public JSONResult delete(@RequestParam(value = "managerId") Integer id){
        managerService.delete(id);

        return new JSONResult().ok("success");
    }

    @DeleteMapping(value = "/deleteAll")
    public JSONResult deleteAll(@RequestParam(value = "list") List list){

        managerService.deleteAll(list);

        return new JSONResult().ok("success");
    }

}
