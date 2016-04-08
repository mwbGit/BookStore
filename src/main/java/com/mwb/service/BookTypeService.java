package com.mwb.service;

import com.mwb.entity.BookType;

import java.util.List;

public interface BookTypeService {

	public void add(BookType bookType);
	public BookType findById(int id);
	public BookType findByName(String name);
	public List<BookType> findAll();
	public void delete(int id);
	public void edit(BookType bookType);
}
