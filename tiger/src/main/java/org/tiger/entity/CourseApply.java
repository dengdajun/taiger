package org.tiger.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Entity
@Table(name = "course_apply")
public class CourseApply {
    @Id
    @GeneratedValue
    @Column(name = "caid")
    private int caid;
    private String name;
    private String phone;
    private String QQ;
    private String consult;
    private String major;
    private String remark;

    public int getCaid() {
        return caid;
    }

    public void setCaid(int caid) {
        this.caid = caid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getConsult() {
        return consult;
    }

    public void setConsult(String consult) {
        this.consult = consult;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
