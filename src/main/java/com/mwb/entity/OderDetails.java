package com.mwb.entity;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 订单详情
 */
public class OderDetails {

    private  int id ;
    private  Oder oder ;
    private  Book book ;
    private  int num ;
    private  double price ;
    private  int state ;
    //状态

    public OderDetails() {
    }

    public OderDetails(Book book, int num, Oder oder, double price, int state) {
        this.book = book;

        this.num = num;
        this.oder = oder;
        this.price = price;
        this.state = state;
    }

    @Override
    public String toString() {
        return "OderDetails{" +
                "book=" + book +
                ", id=" + id +
                ", oder=" + oder +
                ", num=" + num +
                ", price=" + price +
                ", state=" + state +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
