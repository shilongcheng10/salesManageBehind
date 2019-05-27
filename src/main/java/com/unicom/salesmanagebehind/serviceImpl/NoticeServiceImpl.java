/**
 * 公告模块ServiceImpl模块
 * 编者：杨昌海
 */

package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.NoticeDao;
import com.unicom.salesmanagebehind.model.Notice;
import com.unicom.salesmanagebehind.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    /**
     * 获取公告列表
     *
     * @return
     */
    public List<Notice> getAllNotice() {

        return noticeDao.getAllNotice();
    }

    /**
     * 删除公告
     *
     * @param noticeId
     * @return
     */
    public int deleteByPrimaryKey(int noticeId) {

        return noticeDao.deleteByPrimaryKey(noticeId);
    }

    /**
     * 新增公告
     *
     * @param notice
     * @return
     */
    public int addNotice(Notice notice) {

        return noticeDao.insertSelective(notice);
    }

    /**
     * 更新
     * @param notice
     * @return
     */
    public int updateNotice(Notice notice){

        return noticeDao.updateByPrimaryKey(notice);
    }

    /**
     * 后端分页，筛选
     * @param noticeTitle
     * @return
     */
     public List<Notice> getListByCondition(String noticeTitle,String updateTime){

         return noticeDao.getListByCondition(noticeTitle,updateTime);
     }


     public int deleteByIds(List<Integer> ids){

         return  noticeDao.deleteByIds(ids);
     }



}
