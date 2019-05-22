package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.dao.NoticeDao;
import com.unicom.salesmanagebehind.model.Notice;
import java.util.List;


public interface NoticeService {

    List<Notice> getAllNotice();
    int deleteByPrimaryKey(int noticeId);
}