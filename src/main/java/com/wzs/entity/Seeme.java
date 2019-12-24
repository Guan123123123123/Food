package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seeme")
public class Seeme {
    @Id
    @Column(name = "seemeid")
    private Integer seemeid;
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "aid2")
    private Integer aid2;

    @Override
    public String toString() {
        return "Seeme{" +
                "seemeid=" + seemeid +
                ", aid=" + aid +
                ", aid2=" + aid2 +
                '}';
    }

    public Integer getSeemeid() {
        return seemeid;
    }

    public void setSeemeid(Integer seemeid) {
        this.seemeid = seemeid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAid2() {
        return aid2;
    }

    public void setAid2(Integer aid2) {
        this.aid2 = aid2;
    }
}
