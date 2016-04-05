package com.mwb.entity;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 订单详情
 */
public class OderDetails {

    private  int id ;
    private  Oder oderid ;
    private  Book bookid ;
    private  int num ;
    private  float price ;
    private  int state ;
    //状态

    public OderDetails() {
    }

    public OderDetails(Book bookid, int id, int num, Oder oderid, float price, int state) {
        this.bookid = bookid;
        this.id = id;
        this.num = num;
        this.oderid = oderid;
        this.price = price;
        this.state = state;
    }

    @Override
    public String toString() {
        return "OderDetails{" +
                "bookid=" + bookid +
                ", id=" + id +
                ", oderid=" + oderid +
                ", num=" + num +
                ", price=" + price +
                ", state=" + state +
                '}';
    }

    public Book getBookid() {
        return bookid;
    }

    public void setBookid(Book bookid) {
        this.bookid = bookid;
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

    public Oder getOderid() {
        return oderid;
    }

    public void setOderid(Oder oderid) {
        this.oderid = oderid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
