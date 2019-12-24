package com.wzs.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "aname")
    private String aname;
    @Column(name = "apassword")
    private String apassword;
    @Column(name = "aimg")
    private String aimg;
    @Column(name = "aphone")
    private String aphone;
    @Column(name = "accountstate")
    private Integer accountstate;
    @Column(name = "accountdian")
    private Integer accountdian;
    @Column(name = "vipid")
    private Integer vipid;
    @Column(name = "levelsid")
    private Integer levelsid;
    @Column(name = "fensi")
    private Integer fensi;
    @Column(name = "atime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT-8")
    private String atime;
    @Column(name = "beginTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT-8")
    private String beginTime;
    @Column(name = "endTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT-8")
    private String endTime;


    public Account(Integer aid, String aname, String apassword, String aimg, String aphone, Integer accountstate, Integer accountdian, Integer vipid, Integer levelsid, Integer fensi, String atime, String beginTime, String endTime) {
        this.aid = aid;
        this.aname = aname;
        this.apassword = apassword;
        this.aimg = aimg;
        this.aphone = aphone;
        this.accountstate = accountstate;
        this.accountdian = accountdian;
        this.vipid = vipid;
        this.levelsid = levelsid;
        this.fensi = fensi;
        this.atime = atime;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Account() {
    }


    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                ", aimg='" + aimg + '\'' +
                ", aphone='" + aphone + '\'' +
                ", accountstate=" + accountstate +
                ", accountdian=" + accountdian +
                ", vipid=" + vipid +
                ", levelsid=" + levelsid +
                ", fensi=" + fensi +
                ", atime='" + atime + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getAimg() {
        return aimg;
    }

    public void setAimg(String aimg) {
        this.aimg = aimg;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public Integer getAccountstate() {
        return accountstate;
    }

    public void setAccountstate(Integer accountstate) {
        this.accountstate = accountstate;
    }

    public Integer getAccountdian() {
        return accountdian;
    }

    public void setAccountdian(Integer accountdian) {
        this.accountdian = accountdian;
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public Integer getLevelsid() {
        return levelsid;
    }

    public void setLevelsid(Integer levelsid) {
        this.levelsid = levelsid;
    }

    public Integer getFensi() {
        return fensi;
    }

    public void setFensi(Integer fensi) {
        this.fensi = fensi;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
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
