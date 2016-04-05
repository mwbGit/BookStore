package com.mwb.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 订单
 */
public class Oder {
    private int id;
    private User userid;
    private Date date;
    private int num;
    private float price;
    //总价
    private String name;
    //收货人
    private String adress;
    private String tel;

    public Oder() {
    }

    public Oder(String adress, Date date, int id, String name, int num, float price, String tel, User userid) {
        this.adress = adress;
        this.date = date;
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
        this.tel = tel;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "adress='" + adress + '\'' +
                ", id=" + id +
                ", userid=" + userid +
                ", date=" + date +
                ", num=" + num +
                ", price=" + price +
                ", name='" + name + '\'' +
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
}
