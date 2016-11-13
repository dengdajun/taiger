package org.tiger.entity;

import support.support.ExtJSBaseParameter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Entity
@Table(name = "open_class")
public class OpenClass extends ExtJSBaseParameter {
    @Id
    @GeneratedValue
    @Column(name = "ocid")
    private int id;
    private String content;
    private String time;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
