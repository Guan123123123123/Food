package com.wzs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
public class Levels {
    @Id
    @Column(name="levelsid")
    private Integer levelsid;
    @Column(name="levelsname")
    private String levelsname;
    @Column(name="cooknumber")
    private Integer cooknumber;

    @Override
    public String toString() {
        return "Levels{" +
                "levelsid=" + levelsid +
                ", levelsname='" + levelsname + '\'' +
                ", cooknumber=" + cooknumber +
                '}';
    }

    public Integer getLevelsid() {
        return levelsid;
    }

    public void setLevelsid(Integer levelsid) {
        this.levelsid = levelsid;
    }

    public String getLevelsname() {
        return levelsname;
    }

    public void setLevelsname(String levelsname) {
        this.levelsname = levelsname;
    }

    public Integer getCooknumber() {
        return cooknumber;
    }

    public void setCooknumber(Integer cooknumber) {
        this.cooknumber = cooknumber;
    }
}
