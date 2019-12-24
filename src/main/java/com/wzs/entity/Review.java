package com.wzs.entity;

import org.omg.CORBA.INTERNAL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "rid")
    private Integer rid;
    @Column(name = "cookid")
    private Integer cookid;
    @Column(name = "content")
    private String content;
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "rvtime")
    private String rvtime;
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "oauthAvatar")
    private String oauthAvatar;

    @Override
    public String toString() {
        return "Review{" +
                "rid=" + rid +
                ", cookid=" + cookid +
                ", content='" + content + '\'' +
                ", aid=" + aid +
                ", rvtime='" + rvtime + '\'' +
                ", pid=" + pid +
                ", oauthAvatar='" + oauthAvatar + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCookid() {
        return cookid;
    }

    public void setCookid(Integer cookid) {
        this.cookid = cookid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getRvtime() {
        return rvtime;
    }

    public void setRvtime(String rvtime) {
        this.rvtime = rvtime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getOauthAvatar() {
        return oauthAvatar;
    }

    public void setOauthAvatar(String oauthAvatar) {
        this.oauthAvatar = oauthAvatar;
    }
}
