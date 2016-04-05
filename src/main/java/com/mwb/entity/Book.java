package com.mwb.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/4/5 0005.
 * book
 */
public class Book {
    private int id;
    private String name;
    private BookType booktype;
    private String press;
    //出版社
    private Date pressdate;
    //出版日期
    private String author;
    private String introduction;
    private double marketprice;
    //市场价
    private double memberprice;
    //会员价
    private int volume;
    //成交量

    public Book() {
    }

    public Book( String name, BookType booktype, String press, Date pressdate, String author, String introduction, double marketprice, double memberprice, int volume) {
        this.name = name;
        this.booktype = booktype;
        this.press = press;
        this.pressdate = pressdate;
        this.author = author;
        this.introduction = introduction;
        this.marketprice = marketprice;
        this.memberprice = memberprice;
        this.volume = volume;
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

    public BookType getBooktype() {
        return booktype;
    }

    public void setBooktype(BookType booktype) {
        this.booktype = booktype;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPressdate() {
        return pressdate;
    }

    public void setPressdate(Date pressdate) {
        this.pressdate = pressdate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(double marketprice) {
        this.marketprice = marketprice;
    }

    public double getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(double memberprice) {
        this.memberprice = memberprice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
