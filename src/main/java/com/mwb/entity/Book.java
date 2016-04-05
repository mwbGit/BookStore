package com.mwb.entity;

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
    private String pressdate;
    //出版日期
    private String author;
    private String introduction;
    private float marketprice;
    //市场价
    private float memberprice;
    //会员价
    private int volume;
    //成交量

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", booktype=" + booktype +
                ", press='" + press + '\'' +
                ", pressdate='" + pressdate + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                ", marketprice=" + marketprice +
                ", memberprice=" + memberprice +
                ", volume=" + volume +
                '}';
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

    public String getPressdate() {
        return pressdate;
    }

    public void setPressdate(String pressdate) {
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

    public float getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(float marketprice) {
        this.marketprice = marketprice;
    }

    public float getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(float memberprice) {
        this.memberprice = memberprice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
