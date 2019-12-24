package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "vip")
public class Vip {
    @Id
    @Column(name = "vipid")
    private Integer vipid;
    @Column(name = "vipname")
    private String vipname;
    @Column(name = "vipdian")
    private Integer vipdian;

    @Override
    public String toString() {
        return "Vip{" +
                "vipid=" + vipid +
                ", vipname='" + vipname + '\'' +
                ", vipdian=" + vipdian +
                '}';
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public String getVipname() {
        return vipname;
    }

    public void setVipname(String vipname) {
        this.vipname = vipname;
    }

    public Integer getVipdian() {
        return vipdian;
    }

    public void setVipdian(Integer vipdian) {
        this.vipdian = vipdian;
    }
}
