package com.mwb.entity;

import com.mwb.util.FomateDate;

import java.util.Date;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 订单
 */
public class Oder {
    private int id;
    private User user;
    private Date date;
    private int num;
    private double price;
    //总价
    private String realname;
    //收货人
    private String adress;
    private String tel;
    //未发货0 发货1
    private int status;
    private String datestr;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDatestr() {
        return datestr;
    }

    public void setDatestr(String datestr) {
        this.datestr = datestr;
    }

    public Oder() {
    }

    public Oder(String adress, Date date,String realname, int num, double price, String tel, User user) {
        this.adress = adress;
        this.date = date;
        this.realname = realname;
        this.num = num;
        this.price = price;
        this.tel = tel;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "adress='" + adress + '\'' +
                ", id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", num=" + num +
                ", price=" + price +
                ", realname='" + realname + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.datestr = FomateDate.DateToStr(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
