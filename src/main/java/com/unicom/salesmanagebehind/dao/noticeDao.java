package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Notice;

public interface noticeDao {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}