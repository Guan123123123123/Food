package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "uimg")
    private String uimg;
    @Column(name = "uname")
    private String uname;
    @Column(name = "upassword")
    private String upassword;
    @Column(name = "ustate")
    private Integer ustate;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uimg='" + uimg + '\'' +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", ustate=" + ustate +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }
}
