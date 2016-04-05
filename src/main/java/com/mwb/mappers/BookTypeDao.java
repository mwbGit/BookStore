package com.mwb.mappers;

import com.mwb.entity.Admin;
import com.mwb.entity.BookType;

import java.util.List;

public interface BookTypeDao {

	public void add(BookType bookType);
	public BookType findById(int id);
	public BookType findByName(String name);
	public List<BookType> findAll();
	public void delete(int id);
	public void edit(BookType bookType);
}
