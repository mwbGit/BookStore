package com.mwb.service;

import com.mwb.entity.Book;

import java.util.List;

public interface BookService {

	public void add(Book book);
	public Book find(int id);
	public void delete(int id);
	public void edit(Book book);
	public List<Book> findAll();
}
