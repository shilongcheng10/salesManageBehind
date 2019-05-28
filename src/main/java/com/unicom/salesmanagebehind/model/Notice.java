package com.unicom.salesmanagebehind.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description="公告信息")
public class Notice {
    @ApiModelProperty(value="公告信息id",name="noticeId",required=true)
    private Integer noticeId;

    @ApiModelProperty(value="公告标题",name="noticeTitle",required=true)
    private String noticeTitle;

    @ApiModelProperty(value="公告内容",name="noticeContent",required=true)
    private String noticeContent;

    @ApiModelProperty(value="公告最近修改人",name="updateTime",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",locale = "zh",timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value="公告最近更新人",name="updateUser",required=true)
    private String updateUser;

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}