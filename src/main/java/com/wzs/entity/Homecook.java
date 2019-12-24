package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "homecook")
public class Homecook {
    @Id
    @Column(name = "homeid")
    private Integer homeid;
    @Column(name = "homename")
    private String homename;

    public Homecook() {
    }

    public Homecook(Integer homeid, String homename) {
        this.homeid = homeid;
        this.homename = homename;
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public String getHomename() {
        return homename;
    }

    public void setHomename(String homename) {
        this.homename = homename;
    }

    @Override
    public String toString() {
        return "Homecook{" +
                "homeid=" + homeid +
                ", homename='" + homename + '\'' +
                '}';
    }
}
