package com.mwb.entity;

/**
 * Created by Administrator on 2016/4/5 0005.
 * book类型
 */
public class BookType {
    private  int id;
    private String name;

    public BookType() {
    }

    public BookType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
