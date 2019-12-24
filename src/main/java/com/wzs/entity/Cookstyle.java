package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cookstyle")
public class Cookstyle {
    @Id
    @Column(name = "styleid")
    private Integer styleid;
    @Column(name = "stylename")
    private String stylename;
    @Column(name = "styleflag")
    private Integer styleflag;

    @Override
    public String toString() {
        return "Cookstyle{" +
                "styleid=" + styleid +
                ", stylename='" + stylename + '\'' +
                ", styleflag=" + styleflag +
                '}';
    }

    public Integer getStyleid() {
        return styleid;
    }

    public void setStyleid(Integer styleid) {
        this.styleid = styleid;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }

    public Integer getStyleflag() {
        return styleflag;
    }

    public void setStyleflag(Integer styleflag) {
        this.styleflag = styleflag;
    }
}
