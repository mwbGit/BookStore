package com.mwb.entity;

/**
 * Created by Administrator on 2016/4/5 0005.
 * 购物车
 */
public class Cart {
    private int id;
    private User user;
    private Book book;
    private int num;
    private int price;

    public Cart() {
    }
    public Cart(Book book, int num, int price, User user) {
        this.book = book;
        this.num = num;
        this.price = price;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "book=" + book +
                ", id=" + id +
                ", user=" + user +
                ", num=" + num +
                ", price=" + price +
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
