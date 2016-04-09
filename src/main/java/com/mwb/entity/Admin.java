package com.mwb.entity;

import com.mwb.util.FomateDate;

import java.util.Date;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 管理员
 */
public class Admin {
    private  Integer id;
    private  String name;
    private  String  email;
    private  String  password;
    private  String  tel;
    private  String  lastdatestr;
    private Date lastdate;
    private  int grade;
    //级别
    public Admin() {
    }
    public Admin(String email, int grade, String name, String password) {
        this.email = email;
        this.grade = grade;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLastdatestr() {
        return lastdatestr;
    }

    public void setLastdatestr(String lastdatestr) {
        this.lastdatestr = lastdatestr;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
        this.lastdatestr = FomateDate.DateToStr(lastdate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
