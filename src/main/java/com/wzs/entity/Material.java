package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @Column(name = "materialid")
    private Integer materialid;
    @Column(name = "materialname")
    private String materialname;
    @Column(name = "materialliang")
    private String materialliang;
    @Column(name = "cookid")
    private Integer cookid;

    @Override
    public String toString() {
        return "Material{" +
                "materialid=" + materialid +
                ", materialname='" + materialname + '\'' +
                ", materialliang='" + materialliang + '\'' +
                ", cookid=" + cookid +
                '}';
    }

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMaterialliang() {
        return materialliang;
    }

    public void setMaterialliang(String materialliang) {
        this.materialliang = materialliang;
    }

    public Integer getCookid() {
        return cookid;
    }

    public void setCookid(Integer cookid) {
        this.cookid = cookid;
    }
}
