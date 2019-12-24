package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hard")
public class Hard {
    @Id
    @Column(name = "hardid")
    private Integer hardid;
    @Column(name = "hardname")
    private String hardname;

    public Hard() {
    }

    public Hard(Integer hardid, String hardname) {
        this.hardid = hardid;
        this.hardname = hardname;
    }

    public Integer getHardid() {
        return hardid;
    }

    public void setHardid(Integer hardid) {
        this.hardid = hardid;
    }

    public String getHardname() {
        return hardname;
    }

    public void setHardname(String hardname) {
        this.hardname = hardname;
    }

    @Override
    public String toString() {
        return "Hard{" +
                "hardid=" + hardid +
                ", hardname='" + hardname + '\'' +
                '}';
    }
}
