package org.tiger.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "cid")
    private int cid;
    private String title;
    private String content;
    private Date date;
    private String videotitle;
    private String video;
    private String examtitle;
    private String exam;
    private int ctype;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getVideotitle() {
        return videotitle;
    }

    public void setVideotitle(String videotitle) {
        this.videotitle = videotitle;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getExamtitle() {
        return examtitle;
    }

    public void setExamtitle(String examtitle) {
        this.examtitle = examtitle;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public int getCtype() {
        return ctype;
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }
}
