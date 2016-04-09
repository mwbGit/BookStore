package com.mwb.entity;

/**
 * Created by Administrator on 2016/4/9 0009.
 */

/**
 * 分页
 */
public class Pagination {
    private Integer index;
    private Integer size;
    private Integer count;
    private Integer pages;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
