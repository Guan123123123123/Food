package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")

public class Food {
    @Id
    @Column(name = "fid")
    private Integer fid;
    @Column(name = "foodname")
    private String foodname;
    @Column(name = "foodnametwo")
    private String foodnametwo;
    @Column(name = "advice")
    private String advice;
    @Column(name = "okpeople")
    private String okpeople;

    public String getOnpeople() {
        return onpeople;
    }

    public void setOnpeople(String onpeople) {
        this.onpeople = onpeople;
    }

    @Column(name = "onpeople")
    private String onpeople;
    @Column(name = "typeid")
    private Integer typeid;
    @Column(name = "funtionid")
    private Integer funtionid;
    @Column(name = "foodimg")
    private String foodimg ;

    @Override
    public String toString() {
        return "Food{" +
                "fid=" + fid +
                ", foodname='" + foodname + '\'' +
                ", foodnametwo='" + foodnametwo + '\'' +
                ", advice='" + advice + '\'' +
                ", okpeople='" + okpeople + '\'' +
                ", onpeople='" + onpeople + '\'' +
                ", typeid=" + typeid +
                ", funtionid=" + funtionid +
                ", foodimg='" + foodimg + '\'' +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodnametwo() {
        return foodnametwo;
    }

    public void setFoodnametwo(String foodnametwo) {
        this.foodnametwo = foodnametwo;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getOkpeople() {
        return okpeople;
    }

    public void setOkpeople(String okpeople) {
        this.okpeople = okpeople;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getFuntionid() {
        return funtionid;
    }

    public void setFuntionid(Integer funtionid) {
        this.funtionid = funtionid;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }
}
