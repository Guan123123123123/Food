package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* 小吃表*/
@Entity
@Table(name = "speacecook")
public class Speacecook {
    @Id
    @Column(name=  "speaceid")
    private Integer speaceid;
    @Column(name="speacename")
    private String speacename;

    public Speacecook() {
    }

    public Speacecook(Integer speaceid, String speacename) {
        this.speaceid = speaceid;
        this.speacename = speacename;
    }

    @Override
    public String toString() {
        return "Speacecook{" +
                "speaceid=" + speaceid +
                ", speacename='" + speacename + '\'' +
                '}';
    }

    public Integer getSpeaceid() {
        return speaceid;
    }

    public void setSpeaceid(Integer speaceid) {
        this.speaceid = speaceid;
    }

    public String getSpeacename() {
        return speacename;
    }

    public void setSpeacename(String speacename) {
        this.speacename = speacename;
    }
}
