package org.tiger.entity;

import support.support.ExtJSBaseParameter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Entity
@Table(name = "branch_school")
public class BranchSchool extends ExtJSBaseParameter {
    @Id
    @GeneratedValue
    @Column(name = "bsid")
    private int id;
    @Column(name = "bs_name", length = 20, nullable = false)
    private String name;
    @Column(name = "bs_content", length = 200, nullable = false)
    private String content;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date updateTime;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
