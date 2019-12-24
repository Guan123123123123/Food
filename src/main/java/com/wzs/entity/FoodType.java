package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foodtype")
public class FoodType {
    @Id
    @Column(name = "typeid")
    private Integer typeid;
    @Column(name = "typename")
    private String typename;

    public FoodType() {
    }

    public FoodType(Integer typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
