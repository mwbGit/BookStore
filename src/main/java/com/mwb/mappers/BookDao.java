package com.mwb.mappers;

import com.mwb.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookDao {

	public void add(Book Book);
	public Book find(int id);
	public void delete(int id);
	public void edit(Book Book);
	public List<Book> findAll();
	//2个参数 index size
	public List<Book> findNewLimit(Map<String,Object> map);
	//三个参数 booktype index size
	public List<Book> findTypeLimit(Map<String,Object> map);
	//2个参数 index size
	public List<Book> findHotLimit(Map<String,Object> map);
}
