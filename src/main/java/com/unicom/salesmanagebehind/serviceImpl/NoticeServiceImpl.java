package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.NoticeDao;
import com.unicom.salesmanagebehind.model.Notice;
import com.unicom.salesmanagebehind.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    /*
     *
     *
     * */
    public List<Notice> getAllNotice() {
        return noticeDao.getAllNotice();
    }

    public int deleteByPrimaryKey(int noticeId) {
        return noticeDao.deleteByPrimaryKey(noticeId);
    }
}
