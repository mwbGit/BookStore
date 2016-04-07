package com.mwb.controller;

import com.mwb.entity.*;
import com.mwb.service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/static/manager")
public class BookController {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	//添加图书
	@RequestMapping("/bookAdd")
	public String bookAdd(Book book){
		LOGGER.info("request book="+book);
		System.out.println(book);
		bookService.add(book);
		LOGGER.info("book add ok");
		return "redirect:/static/manager/bookadd.jsp";
	}
	//展示图书
	@RequestMapping("/getBooks")
	public String getBooks(Map<String, Object> map){
		LOGGER.info("request getbooks=");
		List<Book> list=bookService.findAll();
		map.put("books", list);
		return "manager/bookshow";
	}
	//删除图书
	@RequestMapping("/bookDelet")
	public String bookDelet(@RequestParam("id") int id){
		LOGGER.info("request bookDelet=");
		bookService.delete(id);
		 return "redirect:/static/manager/getBooks";
	}
	//修改图书
	@RequestMapping("/bookEdit")
	public void bookEdit(Book book){
		LOGGER.info("request bookEdit=");
		Book book2=bookService.find(book.getId());
		book2.setMarketprice(book.getMarketprice());
		book2.setMemberprice(book.getMemberprice());
		book2.setInventory(book.getInventory());
		bookService.edit(book2);
	}
}
