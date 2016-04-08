package com.mwb.controller;

import com.mwb.entity.*;
import com.mwb.service.BookService;
import com.mwb.service.BookServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
	public String bookAdd(Book book,@RequestParam("file") MultipartFile file,HttpServletRequest request){
		LOGGER.info("bookAdd fileup into");
		String img="";
		if (!file.isEmpty()) {
			String filePath = request.getSession().getServletContext().getRealPath("/")
					+ "\\static\\bookimgs\\" +  file.getOriginalFilename();
			img="\\static\\bookimgs\\" +  file.getOriginalFilename();
			//转存文件
			LOGGER.info(" fileup into{}",file.getOriginalFilename());
			LOGGER.info("filePath{}",filePath);
			try {
				file.transferTo(new File(filePath));
				LOGGER.info(file.getOriginalFilename() + "上传文件成功");
			} catch (IOException e) {
				LOGGER.error("IOException{}",e);
				e.printStackTrace();
			}
		}
		LOGGER.info("request book="+book);
		System.out.println(book);
		book.setImg(img);
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
