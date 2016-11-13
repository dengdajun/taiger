package org.tiger.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 小兵哥哥 on 2016/7/27 0027.
 */
@Entity
@Table(name="message_push")
public class MessagePush implements Serializable {

    @Id
    @GeneratedValue
    int id;
    //推送给谁的
    @Column(name = "to_user_id")
    Long toUserId;
    @Column(length = 1000)
    String message;
    @Temporal(TemporalType.TIMESTAMP)
    Date date;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }
}
