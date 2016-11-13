package org.tiger.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue
    @Column(name = "nid")
    private int id;
    private String title;
    private String content;
    private Date date;
    private String ntype;
    private String photo;
    @OneToMany(targetEntity = OpenClass.class)
    @JoinColumn(name="nid")
    private List<OpenClass> openClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNtype() {
        return ntype;
    }

    public void setNtype(String ntype) {
        this.ntype = ntype;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<OpenClass> getOpenClass() {
        return openClass;
    }

    public void setOpenClass(List<OpenClass> openClass) {
        this.openClass = openClass;
    }
}
