/**
 * 公告模块Dao模块
 * 编者：杨昌海
 */
package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Notice;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Mapper
public interface NoticeDao {

    /**
     *
     * 获取所有公告列表
     * @return
     */
    @Select("select * from notice")
    List<Notice> getAllNotice();

    /**
     * 根据条件查询获取列表
     * @param noticeTitle
     * @return
     */
    List<Notice> getListByCondition(
            @Param("noticeTitle")String noticeTitle,
            @Param("updateTime")String updateTime

    );



    /**
     * 删除公告
     * @param noticeId
     * @return
     */
    int deleteByPrimaryKey(int noticeId);

    /**
     * 新增公告
     * @param notice
     * @return
     */
    int insert(Notice notice);

    int insertSelective(Notice notice);

    /**
     * 根据主键查询
     * @param noticeId
     * @return
     */

    Notice selectByPrimaryKey(int noticeId);

    /**
     * 根据主键有选择性更新
     * @param notice
     * @return
     */
    int updateByPrimaryKeySelective(Notice notice);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Notice record);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);
}