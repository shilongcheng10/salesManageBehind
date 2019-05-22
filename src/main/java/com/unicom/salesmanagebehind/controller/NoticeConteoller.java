package com.unicom.salesmanagebehind.controller;



import com.unicom.salesmanagebehind.model.Notice;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.service.NoticeService;
import com.unicom.salesmanagebehind.utils.JSONResult;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "notice")
public class NoticeConteoller {
    @Autowired
    NoticeService noticeService;

    @RequestMapping("/list")
    public JSONResult getAll(){
        List<Notice> list =noticeService.getAllNotice();
        return new JSONResult().ok(list);
    }
//    public ResultPojo getAll(){
//        List<Notice> list =noticeService.getAllNotice();
//        return ResultUtils.success(list);
//    }

    @RequestMapping("/remove")
    public ResultPojo delete(int noticeId){
        noticeService.deleteByPrimaryKey(noticeId);
        return ResultUtils.success();
    }




}
