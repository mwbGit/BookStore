package com.mwb.service;

import com.mwb.entity.BookType;
import com.mwb.mappers.BookTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7 0007.
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeDao bookTypeDao;
    @Override
    public void add(BookType bookType) {
        bookTypeDao.add(bookType);
    }

    @Override
    public BookType findById(int id) {
        return bookTypeDao.findById(id);
    }

    @Override
    public BookType findByName(String name) {
        return bookTypeDao.findByName(name);
    }

    @Override
    public List<BookType> findAll() {
        return bookTypeDao.findAll();
    }

    @Override
    public void delete(int id) {
        bookTypeDao.delete(id);
    }

    @Override
    public void edit(BookType bookType) {
        bookTypeDao.edit(bookType);
    }
}
