package com.mwb.service;

import com.mwb.entity.Book;
import com.mwb.mappers.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/6 0006.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public Book find(int id) {
        return bookDao.find(id);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }

    @Override
    public void edit(Book book) {
        bookDao.edit(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findNewLimit(Map<String, Object> map) {
         return bookDao.findNewLimit(map);
    }

    @Override
    public List<Book> findTypeLimit(Map<String, Object> map) {
        return bookDao.findTypeLimit(map);
    }

    @Override
    public List<Book> findHotLimit(Map<String, Object> map) {
        return bookDao.findHotLimit(map);
    }

    @Override
    public int findTypeCount(int typeid) {
        return bookDao.findTypeCount(typeid);
    }
}
