package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cookbook")
public class Cookbook {
    @Id
    @Column(name = "cookid")
    private Integer cookid;
    @Column(name = "cookname")
    private String cookname;
    @Column(name = "cooknumber")
    private Integer cooknumber;
    @Column(name = "procesid")
    private Integer procesid;
    @Column(name = "tasteid")
    private Integer tasteid;
    @Column(name = "hardid")
    private Integer hardid;
    @Column(name = "styleid")
    private Integer styleid;
    @Column(name = "homeid")
    private Integer homeid;
    @Column(name = "speaceid")
    private Integer speaceid;
    @Column(name = "readlytime")
    private String readlytime;
    @Column(name = "worktime")
    private String worktime;
    @Column(name = "cookcontent")
    private String cookcontent;
    @Column(name = "cookstate")
    private Integer cookstate;
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "viplevel")
    private Integer viplevel;
    @Column(name = "cookimg")
    private String cookimg;

    @Override
    public String toString() {
        return "Cookbook{" +
                "cookid=" + cookid +
                ", cookname='" + cookname + '\'' +
                ", cooknumber=" + cooknumber +
                ", procesid=" + procesid +
                ", tasteid=" + tasteid +
                ", hardid=" + hardid +
                ", styleid=" + styleid +
                ", homeid=" + homeid +
                ", speaceid=" + speaceid +
                ", readlytime='" + readlytime + '\'' +
                ", worktime='" + worktime + '\'' +
                ", cookcontent='" + cookcontent + '\'' +
                ", cookstate=" + cookstate +
                ", aid=" + aid +
                ", viplevel=" + viplevel +
                ", cookimg='" + cookimg + '\'' +
                '}';
    }

    public Integer getCookid() {
        return cookid;
    }

    public void setCookid(Integer cookid) {
        this.cookid = cookid;
    }

    public String getCookname() {
        return cookname;
    }

    public void setCookname(String cookname) {
        this.cookname = cookname;
    }

    public Integer getCooknumber() {
        return cooknumber;
    }

    public void setCooknumber(Integer cooknumber) {
        this.cooknumber = cooknumber;
    }

    public Integer getProcesid() {
        return procesid;
    }

    public void setProcesid(Integer procesid) {
        this.procesid = procesid;
    }

    public Integer getTasteid() {
        return tasteid;
    }

    public void setTasteid(Integer tasteid) {
        this.tasteid = tasteid;
    }

    public Integer getHardid() {
        return hardid;
    }

    public void setHardid(Integer hardid) {
        this.hardid = hardid;
    }

    public Integer getStyleid() {
        return styleid;
    }

    public void setStyleid(Integer styleid) {
        this.styleid = styleid;
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public Integer getSpeaceid() {
        return speaceid;
    }

    public void setSpeaceid(Integer speaceid) {
        this.speaceid = speaceid;
    }

    public String getReadlytime() {
        return readlytime;
    }

    public void setReadlytime(String readlytime) {
        this.readlytime = readlytime;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getCookcontent() {
        return cookcontent;
    }

    public void setCookcontent(String cookcontent) {
        this.cookcontent = cookcontent;
    }

    public Integer getCookstate() {
        return cookstate;
    }

    public void setCookstate(Integer cookstate) {
        this.cookstate = cookstate;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getViplevel() {
        return viplevel;
    }

    public void setViplevel(Integer viplevel) {
        this.viplevel = viplevel;
    }

    public String getCookimg() {
        return cookimg;
    }

    public void setCookimg(String cookimg) {
        this.cookimg = cookimg;
    }
}
