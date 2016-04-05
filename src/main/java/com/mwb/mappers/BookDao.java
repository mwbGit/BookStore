package com.mwb.mappers;

import com.mwb.entity.Book;

import java.util.List;

public interface BookDao {

	public void add(Book Book);
	public Book find(int id);
	public void delete(int id);
	public void edit(Book Book);
	public List<Book> findAll();
}
