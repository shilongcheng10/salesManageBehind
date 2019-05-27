package com.unicom.salesmanagebehind.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.ManagerService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Transactional
    @PostMapping("/login")
    public ResultPojo loginUser(@RequestBody Manager manager ) {
//        Map<String,Object> result = new HashMap<String, Object>();

        Manager manage = managerService.isLoginSuccess(manager);
        if(manage!=null) {
            String tokenInside=managerService.getTokenById(manage.getManagerId());
            if (!tokenInside.equals("logout")){
                return ResultUtils.error(50012,"该账户已在其他地方登录");
            }
            String token= UUID.randomUUID().toString();
            Manager manager1=new Manager();
            manager1.setManagerId(manage.getManagerId());
            manager1.setToken(token);
            try {
                managerService.updateTokenById(manager1);
                return ResultUtils.success("登录成功",token);
            }catch (Exception e){
                e.printStackTrace();
                return ResultUtils.error(-1,e.getMessage());
            }
        }else{
            return ResultUtils.error(-2,"账号名或密码错误或者不存在此用户");
        }

    }
    @GetMapping(value = "info")
    public ResultPojo getInfo(@RequestParam(name = "token") String token){
        if (token.equals("logout")){
            return ResultUtils.error(-3,"用户信息获取错误！");
        }
        Manager manager=managerService.getUserInfoByToken(token);
        if (manager==null){
            return ResultUtils.error(-2,"不存在相关的用户信息");
        }else{
            return ResultUtils.success("获得用户信息成功",manager);
        }
    }

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

    @Transactional
    @PostMapping(value="logout")
    public ResultPojo logOut(@RequestParam(name = "token") String token){
        try {
            managerService.logout(token);
            return ResultUtils.success("注销成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(-1,e.getMessage());
        }
    }

}
