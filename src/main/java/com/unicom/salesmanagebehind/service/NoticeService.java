/**
 * 公告模块Service模块
 * 编者：杨昌海
 */

package com.unicom.salesmanagebehind.service;
import com.unicom.salesmanagebehind.model.Notice;

import java.sql.Date;
import java.util.List;


public interface NoticeService {
    //获取列表
    List<Notice> getAllNotice();
    //删除
    int deleteByPrimaryKey(int noticeId);

    //新增
    int addNotice(Notice notice);

    //更新
    int updateNotice(Notice notice);

   //后端分页，筛选列表
    List<Notice> getListByCondition(String noticeTitle,String updateTime);

    //批量删除
    int deleteByIds(List<Integer> ids);

}