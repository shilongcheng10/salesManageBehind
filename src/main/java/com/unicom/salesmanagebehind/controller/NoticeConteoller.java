/**
 * 公告模块Controller3模块
 * 编者：杨昌海
 */


package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.Notice;
import com.unicom.salesmanagebehind.service.NoticeService;
import com.unicom.salesmanagebehind.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "notice")
@Api(tags = "触点营销后台管理系统-公告管理系统")
public class NoticeConteoller {
    @Autowired
    NoticeService noticeService;

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
            @RequestParam(name = "noticeId",defaultValue = "0") int noticeId
    ) throws Exception {
        noticeService.deleteByPrimaryKey(noticeId);
        return new JSONResult().ok("success");
    }


    /**
     * 新增公告
     *
     * @param notice
     * @return
     */

    @PostMapping("/add")
    @ApiOperation(value = "新增公告")
    public JSONResult addNotice(@RequestBody Notice notice) throws Exception {
        System.out.println(notice.getNoticeContent());
        noticeService.addNotice(notice);
        return new JSONResult().ok("success");
    }

    /**
     * 更新公告
     *
     * @param notice
     * @return
     */

    @PutMapping("/edit")
    public JSONResult update(Notice notice) throws Exception {

        if (notice != null) {
            noticeService.updateNotice(notice);
        }
        return new JSONResult().ok("success");
    }


    @GetMapping("/list")
    public JSONResult selectList(
            @RequestParam(value = "page", defaultValue = "1")  int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "noticeTitle", defaultValue = "") String noticeTitle,
            @RequestParam(name = "updateTime", defaultValue = "") String updateTime

    ) throws Exception {
        PageHelper.startPage(page, limit);
        List<Notice> list = noticeService.getListByCondition(noticeTitle,updateTime);
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);
    }

    @DeleteMapping("/batchremove")
    public JSONResult deleteByIds(@RequestParam(name = "ids")  List<Integer> ids) throws Exception {
        int s = noticeService.deleteByIds(ids);
        System.out.println("影响的行数为" + s);
        return new JSONResult().ok("success");
    }

}
