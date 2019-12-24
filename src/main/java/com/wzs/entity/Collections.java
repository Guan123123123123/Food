package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collection")
public class Collections {
    @Id
    @Column(name = "collectionid")
    private Integer collectionid;
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "cookid")
    private Integer cookid;

    @Override
    public String toString() {
        return "Collections{" +
                "collectionid=" + collectionid +
                ", aid=" + aid +
                ", cookid=" + cookid +
                '}';
    }

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollection(Integer collection) {
        this.collectionid = collection;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCookid() {
        return cookid;
    }

    public void setCookid(Integer cookid) {
        this.cookid = cookid;
    }
}
