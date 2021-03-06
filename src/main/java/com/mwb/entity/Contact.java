package com.mwb.entity;

import com.mwb.util.FomateDate;

import java.util.Date;


/**
 * Created by Administrator on 2016/4/9 0009.
 * 留言
 */
public class Contact {
    private Integer id;
    private String name;
    private String tel;
    private String email;
    private String message;
    private Date date;
    private String datestr;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatestr() {
        return datestr;
    }

    public void setDatestr(String datestr) {
        this.datestr = datestr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.datestr = FomateDate.DateToStr(date);
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
