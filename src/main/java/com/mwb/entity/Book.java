package com.mwb.entity;

import com.mwb.util.FomateDate;
import com.mwb.util.FormatDouble;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/5 0005.
 * book
 */
public class Book {
    private Integer id;
    private String name;
    private BookType booktype;
    private String press;
    //出版社
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date pressdate;
    //出版日期
    private String author;
    private String introduction;
    //市场价
    private double marketprice;
    //会员价
    private double memberprice;
    //成交量
    private int volume;
    //库存
    private int inventory;
    private String img;
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", booktype=" + booktype +
                ", press='" + press + '\'' +
                ", pressdate=" + pressdate +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                ", marketprice=" + marketprice +
                ", memberprice=" + memberprice +
                ", volume=" + volume +
                ", inventory=" + inventory +
                ", img='" + img + '\'' +
                '}';
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
        this.dateStr= FomateDate.DatetoStr(pressdate);
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
        this.marketprice = FormatDouble.getToDoble(marketprice);
    }

    public double getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(double memberprice) {
        this.memberprice = FormatDouble.getToDoble(memberprice);

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
