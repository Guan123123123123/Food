package com.wzs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "know")
public class Know {
    @Id
    private Integer knowid;
    @Column(name = "knowname")
    private String knowname;
    @Column(name = "knowcontent")
    private String knowcontent;
    @Column(name = "knowtypeid")
    private Integer knowtypeid;
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "knowbegintime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT-8")
    private String knowbegintime;

    @Override
    public String toString() {
        return "Know{" +
                "knowid=" + knowid +
                ", knowname='" + knowname + '\'' +
                ", knowcontent=" + knowcontent +
                ", knowtypeid=" + knowtypeid +
                ", aid=" + aid +
                ", knowbegintime='" + knowbegintime + '\'' +
                '}';
    }

    public Integer getKnowid() {
        return knowid;
    }

    public void setKnowid(Integer knowid) {
        this.knowid = knowid;
    }

    public String getKnowname() {
        return knowname;
    }

    public void setKnowname(String knowname) {
        this.knowname = knowname;
    }

    public String getKnowcontent() {
        return knowcontent;
    }

    public void setKnowcontent(String knowcontent) {
        this.knowcontent = knowcontent;
    }

    public Integer getKnowtypeid() {
        return knowtypeid;
    }

    public void setKnowtypeid(Integer knowtypeid) {
        this.knowtypeid = knowtypeid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getKnowbegintime() {
        return knowbegintime;
    }

    public void setKnowbegintime(String knowbegintime) {
        this.knowbegintime = knowbegintime;
    }
}
