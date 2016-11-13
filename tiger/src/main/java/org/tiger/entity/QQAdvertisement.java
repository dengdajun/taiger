package org.tiger.entity;

import support.support.ExtJSBaseParameter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by YoungMan on 2016/11/13.
 */
@Entity
@Table(name = "qq_advertisement")
public class QQAdvertisement extends ExtJSBaseParameter {
    @Id
    @GeneratedValue
    @Column(name = "qq_id")
    private int id;
    private String talk;
     private String message;
    private Date time;




    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
