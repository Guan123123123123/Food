package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proces")
public class Proces {
    @Id
    @Column(name = "procesid")
    private Integer procesid;
    @Column(name = "procesname")
    private String procesname;

    public Proces(Integer procesid, String procesname) {
        this.procesid = procesid;
        this.procesname = procesname;
    }

    public Proces() {
    }

    @Override
    public String toString() {
        return "Proces{" +
                "procesid=" + procesid +
                ", procesname='" + procesname + '\'' +
                '}';
    }

    public Integer getProcesid() {
        return procesid;
    }

    public void setProcesid(Integer procesid) {
        this.procesid = procesid;
    }

    public String getProcesname() {
        return procesname;
    }

    public void setProcesname(String procesname) {
        this.procesname = procesname;
    }
}
