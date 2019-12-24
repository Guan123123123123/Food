package com.wzs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mv")
public class Mv {
    @Id
    @Column(name = "mvid")
    private Integer mvid;
    @Column(name = "mvurl")
    private String mvurl;
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "mvbegintime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT-8")
    private String mvbegintime;
    @Column(name = "mvname")
    private String mvname;
    @Column(name = "mvcontent")
    private String mvcontent;

    public Mv(Integer mvid, String mvurl, Integer aid, String mvbegintime, String mvname, String mvcontent) {
        this.mvid = mvid;
        this.mvurl = mvurl;
        this.aid = aid;
        this.mvbegintime = mvbegintime;
        this.mvname = mvname;
        this.mvcontent = mvcontent;
    }

    public Mv() {
    }

    @Override
    public String toString() {
        return "Mv{" +
                "mvid=" + mvid +
                ", mvurl='" + mvurl + '\'' +
                ", aid=" + aid +
                ", mvbegintime='" + mvbegintime + '\'' +
                ", mvname='" + mvname + '\'' +
                ", mvcontent='" + mvcontent + '\'' +
                '}';
    }

    public Integer getMvid() {
        return mvid;
    }

    public void setMvid(Integer mvid) {
        this.mvid = mvid;
    }

    public String getMvurl() {
        return mvurl;
    }

    public void setMvurl(String mvurl) {
        this.mvurl = mvurl;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getMvbegintime() {
        return mvbegintime;
    }

    public void setMvbegintime(String mvbegintime) {
        this.mvbegintime = mvbegintime;
    }

    public String getMvname() {
        return mvname;
    }

    public void setMvname(String mvname) {
        this.mvname = mvname;
    }

    public String getMvcontent() {
        return mvcontent;
    }

    public void setMvcontent(String mvcontent) {
        this.mvcontent = mvcontent;
    }
}
