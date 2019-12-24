package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knowtype")
public class Knowtype {
    @Id
    @Column(name = "knowtypeid")
    private Integer knowtypeid;
    @Column(name = "knowtypename")
    private String knowtypename;

    @Override
    public String toString() {
        return "Knowtype{" +
                "knowtypeid=" + knowtypeid +
                ", knowtypename='" + knowtypename + '\'' +
                '}';
    }

    public Integer getKnowtypeid() {
        return knowtypeid;
    }

    public void setKnowtypeid(Integer knowtypeid) {
        this.knowtypeid = knowtypeid;
    }

    public String getKnowtypename() {
        return knowtypename;
    }

    public void setKnowtypename(String knowtypename) {
        this.knowtypename = knowtypename;
    }
}
