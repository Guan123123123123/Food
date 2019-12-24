package com.wzs.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taste")
public class Taste  {
    @Id
    @Column(name = "tasteid")
    private Integer tasteid;
    @Column(name = "tastename")
    private String tastename;

    public Taste() {
    }

    public Taste(Integer tasteid, String tastename) {
        this.tasteid = tasteid;
        this.tastename = tastename;
    }

    @Override
    public String toString() {
        return "Taste{" +
                "tasteid=" + tasteid +
                ", tastename='" + tastename + '\'' +
                '}';
    }

    public Integer getTasteid() {
        return tasteid;
    }

    public void setTasteid(Integer tasteid) {
        this.tasteid = tasteid;
    }

    public String getTastename() {
        return tastename;
    }

    public void setTastename(String tastename) {
        this.tastename = tastename;
    }
}
