package com.unicom.salesmanagebehind.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.ManagerService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = {"触点营销后台管理系统-管理员管理模块"})
@RestController
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @ApiOperation(value = "管理员用户密码修改")
    @ApiImplicitParam(name ="jsonObject",value = "前端传输的token，密码等信息",required = true,dataType = "JSONObject")
    @Transactional
    @PostMapping(value = "updatePassword")
    public ResultPojo changePassword(@RequestBody JSONObject jsonObject){
        String token = jsonObject.get("token").toString();
        String oldPassword=jsonObject.get("oldPassword").toString();
        String newPassword=jsonObject.get("newPassword").toString();
        String confirmPassword=jsonObject.get("confirmPassword").toString();
        if (token==null || token.equals("")){
            return  ResultUtils.error(-1,"管理员用户token不能为空！");
        }
        if (oldPassword==null||oldPassword.equals("")){
            return  ResultUtils.error(-2,"原密码不能为空！");
        }
        if (newPassword==null||newPassword.equals("")){
            return  ResultUtils.error(-3,"新密码不能为空！");
        }
        if (confirmPassword==null||confirmPassword.equals("")){
            return  ResultUtils.error(-4,"确认密码不能为空！");
        }
        if(!newPassword.equals(confirmPassword)){
            return ResultUtils.error(-5,"两次输入的密码不一致！");
        }
        if (!(managerService.getPasswordByToken(token).equals(oldPassword))){
            return ResultUtils.error(-7,"用户密码错误！");
        }
        Manager manager = new Manager();
        manager.setToken(token);
        manager.setPassword(newPassword);
        try {
            managerService.updatePasswordByToken(manager);
            return ResultUtils.success("更新密码成功");
        }catch (Exception e){
            return ResultUtils.error(-6,"更新密码失败！");
        }
    }
    @ApiOperation(value = "当前管理员用户登录处理")
    @ApiImplicitParam(name ="manager",value = "当前管理员的登录信息",required = true,dataType = "Manager")
    @Transactional
    @PostMapping("/login")
    public ResultPojo loginUser(@RequestBody Manager manager ) {
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

    @ApiOperation(value = "获取当前管理员用户的信息")
    @ApiImplicitParam(name ="token",value = "当前登录用户的token信息",required = true,dataType = "String")
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

    @ApiOperation(value = "获取当前管理员用户列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="page",value = "列表显示管理员用户的页数",required = true,dataType = "int"),
            @ApiImplicitParam(name ="limit",value = "一页中显示管理员用户的数量",required = true,dataType = "int"),
            @ApiImplicitParam(name ="managerId",value = "管理员用户编码",required = true,dataType = "Integer"),
            @ApiImplicitParam(name ="managerName",value = "管理员用户姓名",required = true,dataType = "String"),
            @ApiImplicitParam(name ="loginName",value = "管理员用户的登录名",required = true,dataType = "String"),
            @ApiImplicitParam(name ="managerTel",value = "管理员用户的联系方式",required = true,dataType = "String"),
    })
    @GetMapping(value = "/list")
    public JSONResult selectList(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "10") int limit,
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

    @ApiOperation(value = "新增管理员用户")
    @ApiImplicitParam(name ="manager",value = "即将添加的管理员的信息",required = true,dataType = "Manager")
    @PostMapping(value = "/add")
    public JSONResult insert(@RequestBody Manager manager){
        int i= managerService.add(manager);

        if (i>0)
            return new JSONResult().ok("success");
        else{
            return null;
        }
    }

    @ApiOperation(value = "管理员用户信息更新")
    @ApiImplicitParam(name ="manager",value = "要修改的管理员用户的信息",required = true,dataType = "Manager")
    @PutMapping(value = "/update")
    public JSONResult update(@RequestBody Manager manager){
        managerService.update(manager);

        return new JSONResult().ok("success");
    }

    @ApiOperation(value = "删除管理员用户")
    @ApiImplicitParam(name ="managerId",value = "管理员用户编码",required = true,dataType = "Integer")
    @DeleteMapping(value="/delete")
    public JSONResult delete(@RequestParam(value = "managerId") Integer id){
        managerService.delete(id);

        return new JSONResult().ok("success");
    }

    @ApiOperation(value = "删除所有管理员用户")
    @ApiImplicitParam(name ="list",value = "管理员用户编码列表",required = true,dataType = "List")
    @DeleteMapping(value = "/deleteAll")
    public JSONResult deleteAll(@RequestParam(value = "list") List list){

        managerService.deleteAll(list);

        return new JSONResult().ok("success");
    }

    @ApiOperation(value = "当前登录管理员用户登出")
    @ApiImplicitParam(name ="token",value = "管理员用户编码列表",required = true,dataType = "String")
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
