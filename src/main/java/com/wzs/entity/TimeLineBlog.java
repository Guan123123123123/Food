package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "time_line_blog")
public class TimeLineBlog {
    /**
     * 时间线ID
     */
    @Id
    private String id;

    /**
     * 流逝时间
     */
    @Column(name = "past_time")
    private String pastTime;

    /**
     * 时间线内容
     */
    @Column(name = "time_line_content")
    private String timeLineContent;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 逻辑删除：0正常，1已删
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 非表内字段
     */
    @Transient
    private String username;

    @Transient
    private String beginTime;

    @Transient
    private String endTime;

    /**
     * 获取时间线ID
     *
     * @return id - 时间线ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置时间线ID
     *
     * @param id 时间线ID
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getPastTime() {
        return pastTime;
    }

    public void setPastTime(String pastTime) {
        this.pastTime = pastTime;
    }

    /**
     * 获取时间线内容
     *
     * @return time_line_content - 时间线内容
     */
    public String getTimeLineContent() {
        return timeLineContent;
    }

    /**
     * 设置时间线内容
     *
     * @param timeLineContent 时间线内容
     */
    public void setTimeLineContent(String timeLineContent) {
        this.timeLineContent = timeLineContent;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取逻辑删除：0正常，1已删
     *
     * @return del_flag - 逻辑删除：0正常，1已删
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除：0正常，1已删
     *
     * @param delFlag 逻辑删除：0正常，1已删
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 非表内字段
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}