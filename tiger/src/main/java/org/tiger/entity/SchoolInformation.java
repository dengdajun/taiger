package org.tiger.entity;

import support.support.ExtJSBaseParameter;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Entity
@Table(name = "school_information")
public class SchoolInformation extends ExtJSBaseParameter {
    @Id
    @GeneratedValue
    @Column(name = "sid")
    private int id;
    private String mobile;
    private String QQ;
    private String QQgroup;
    private Long tel;
    private String address;
    private String introduce;
    private String route;
    private String routedetails;
    private String environment;



    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getQQgroup() {
        return QQgroup;
    }

    public void setQQgroup(String QQgroup) {
        this.QQgroup = QQgroup;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoutedetails() {
        return routedetails;
    }

    public void setRoutedetails(String routedetails) {
        this.routedetails = routedetails;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
