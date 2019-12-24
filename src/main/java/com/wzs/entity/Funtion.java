package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funtion")
public class Funtion {
    @Id
    @Column(name = "funtionid")
    private Integer funtionid;
    @Column(name = "funtionname")
    private String funtionname;

    public Funtion() {
    }

    public Funtion(Integer funtionid, String funtionname) {
        this.funtionid = funtionid;
        this.funtionname = funtionname;
    }

    public Integer getFuntionid() {
        return funtionid;
    }

    public void setFuntionid(Integer funtionid) {
        this.funtionid = funtionid;
    }

    public String getFuntionname() {
        return funtionname;
    }

    public void setFuntionname(String funtionname) {
        this.funtionname = funtionname;
    }

    @Override
    public String toString() {
        return "Funtion{" +
                "funtionid=" + funtionid +
                ", funtionname='" + funtionname + '\'' +
                '}';
    }
}
