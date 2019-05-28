/**
 * 公告模块Controller3模块
 * 编者：杨昌海
 */


package com.unicom.salesmanagebehind.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.Notice;
import com.unicom.salesmanagebehind.service.ManagerService;
import com.unicom.salesmanagebehind.service.NoticeService;

import com.unicom.salesmanagebehind.model.JSONResult;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "notice")
@Api(tags = "触点营销后台管理系统-公告管理系统")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    ManagerService managerService;


    /**
     * 删除公告
     *
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除公告")
//    @ApiImplicitParam(name="noticeId",value = "公告ID",required = true,dataType = "int")
    public JSONResult delete(
            @RequestParam(name = "noticeId", defaultValue = "0") int noticeId
    ) throws Exception {
        noticeService.deleteByPrimaryKey(noticeId);
        return new JSONResult().ok("success");
    }


    /**
     * 新增公告
     *
     * @param params
     * @return
     */

    @PostMapping("/add")
    @ApiOperation(value = "新增公告")
    public JSONResult addNotice(@RequestParam String params) throws Exception {
        JSONObject json = JSON.parseObject(params);
//        System.out.println("前端传的值9" + json.toString());
        Notice notice = new Notice();
        notice.setUpdateTime(new Date());
        notice.setNoticeTitle(json.get("noticeTitle").toString());
        notice.setNoticeContent(json.get("noticeContent").toString());
        String token = json.get("updateUser").toString();
        String updateUser = managerService.getLoginNameByToken(token).trim();
        if (updateUser != null && !updateUser.isEmpty()) {
            notice.setUpdateUser(updateUser);
        } else {
            return new JSONResult().error("管理员未登录");
        }
        try {
            noticeService.addNotice(notice);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JSONResult().ok("success");
    }

    /**
     * 更新公告
     *
     * @param params
     * @return
     */

    @PutMapping("/edit")
    public JSONResult update(@RequestParam String params) throws Exception {

        JSONObject json = JSON.parseObject(params);
        System.out.println("前端传的值是" + json.toString());
        Notice notice = new Notice();
        notice.setUpdateTime(new Date());
        notice.setNoticeId((int) json.get("noticeId"));
        notice.setNoticeTitle(json.get("noticeTitle").toString());
        notice.setNoticeContent(json.get("noticeContent").toString());
        String token = json.get("updateUser").toString();
        String updateUser = managerService.getLoginNameByToken(token).trim();
        if (updateUser != null && !updateUser.isEmpty()) {
            notice.setUpdateUser(updateUser);
        }else {
            return new JSONResult().error("管理员未登录");
        }


        try {
            noticeService.updateNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONResult().ok("success");
    }


    @GetMapping("/list")
    public JSONResult selectList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "noticeTitle", defaultValue = "") String noticeTitle,
            @RequestParam(name = "updateTime", defaultValue = "") String updateTime

    ) throws Exception {
        PageHelper.startPage(page, limit);

        List<Notice> list = noticeService.getListByCondition(noticeTitle, updateTime);
//        System.out.println("后台返回的list" + list);
//        System.out.println();

        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }

    @DeleteMapping("/batchremove")
    public JSONResult deleteByIds(@RequestParam(name = "ids") List<Integer> ids) throws Exception {
        int s = noticeService.deleteByIds(ids);

//        System.out.println("影响的行数为" + s);
        return new JSONResult().ok("success");
    }

}
