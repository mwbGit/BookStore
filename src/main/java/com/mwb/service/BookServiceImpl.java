package com.mwb.service;

import com.mwb.entity.Book;
import com.mwb.mappers.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
