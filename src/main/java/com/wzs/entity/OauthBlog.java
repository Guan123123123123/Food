package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "oauth_blog")
public class OauthBlog {
    /**
     * 第三方登录ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 关联用户表
     */
    @Column(name = "aid")
    private Integer aid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     * 第三方登录类型：qq、weibo等
     */
    @Column(name = "oauth_type")
    private String oauthType;

    /**
     * oauth_id
     */
    @Column(name = "oauth_id")
    private String oauthId;

    /**
     * oauth_access_token 
     */
    @Column(name = "oauth_access_token")
    private String oauthAccessToken;

    /**
     * oauth_expires
     */
    @Column(name = "oauth_expires")
    private String oauthExpires;

    /**
     * oauth_nickname注：qq昵称
     */
    @Column(name = "oauth_nickname")
    private String oauthNickname;

    /**
     * oauth_gender注：qq性别
     */
    @Column(name = "oauth_gender")
    private String oauthGender;

    /**
     * oauth_avatar注：qq头像
     */
    @Column(name = "oauth_avatar")
    private String oauthAvatar;

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
     * 获取第三方登录ID
     *
     * @return id - 第三方登录ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置第三方登录ID
     *
     * @param id 第三方登录ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取关联用户表
     *
     * @return user_id - 关联用户表
     */


    /**
     * 设置关联用户表
     *
     * @param userId 关联用户表
     */


    /**
     * 获取第三方登录类型：qq、weibo等
     *
     * @return oauth_type - 第三方登录类型：qq、weibo等
     */
    public String getOauthType() {
        return oauthType;
    }

    /**
     * 设置第三方登录类型：qq、weibo等
     *
     * @param oauthType 第三方登录类型：qq、weibo等
     */
    public void setOauthType(String oauthType) {
        this.oauthType = oauthType;
    }

    /**
     * 获取oauth_id
     *
     * @return oauth_id - oauth_id
     */
    public String getOauthId() {
        return oauthId;
    }

    /**
     * 设置oauth_id
     *
     * @param oauthId oauth_id
     */
    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    /**
     * 获取oauth_access_token 
     *
     * @return oauth_access_token - oauth_access_token 
     */
    public String getOauthAccessToken() {
        return oauthAccessToken;
    }

    /**
     * 设置oauth_access_token 
     *
     * @param oauthAccessToken oauth_access_token 
     */
    public void setOauthAccessToken(String oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }

    /**
     * 获取oauth_expires
     *
     * @return oauth_expires - oauth_expires
     */
    public String getOauthExpires() {
        return oauthExpires;
    }

    /**
     * 设置oauth_expires
     *
     * @param oauthExpires oauth_expires
     */
    public void setOauthExpires(String oauthExpires) {
        this.oauthExpires = oauthExpires;
    }

    /**
     * 获取oauth_nickname注：qq昵称
     *
     * @return oauth_nickname - oauth_nickname注：qq昵称
     */
    public String getOauthNickname() {
        return oauthNickname;
    }

    /**
     * 设置oauth_nickname注：qq昵称
     *
     * @param oauthNickname oauth_nickname注：qq昵称
     */
    public void setOauthNickname(String oauthNickname) {
        this.oauthNickname = oauthNickname;
    }

    /**
     * 获取oauth_gender注：qq性别
     *
     * @return oauth_gender - oauth_gender注：qq性别
     */
    public String getOauthGender() {
        return oauthGender;
    }

    /**
     * 设置oauth_gender注：qq性别
     *
     * @param oauthGender oauth_gender注：qq性别
     */
    public void setOauthGender(String oauthGender) {
        this.oauthGender = oauthGender;
    }

    /**
     * 获取oauth_avatar注：qq头像
     *
     * @return oauth_avatar - oauth_avatar注：qq头像
     */
    public String getOauthAvatar() {
        return oauthAvatar;
    }

    /**
     * 设置oauth_avatar注：qq头像
     *
     * @param oauthAvatar oauth_avatar注：qq头像
     */
    public void setOauthAvatar(String oauthAvatar) {
        this.oauthAvatar = oauthAvatar;
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
}