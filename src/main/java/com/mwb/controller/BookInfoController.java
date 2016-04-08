package com.mwb.controller;

import com.mwb.service.BookService;
import com.mwb.service.BookTypeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 前台页面
 * 图书展示 详情控制
 */
@Controller
@RequestMapping("/static")
public class BookInfoController {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookInfoController.class);

	@Autowired
	private BookService bookService;
	@Autowired
	private BookTypeService bookTypeService;
	//服务器启动加载 主页
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		LOGGER.info("into  index=");
		HttpSession session=request.getSession();
		Map<String,Object> map=new HashMap<String, Object>();
		//热销第一页
		map.put("index",0);
		map.put("size",12);
		session.setAttribute("hotbooks",bookService.findHotLimit(map));
		//热销排行 新书排行
		map.put("index",0);
		map.put("size",3);
		//热销书籍
		session.setAttribute("hotbook", bookService.findHotLimit(map));
		//新书
		session.setAttribute("newbooks", bookService.findNewLimit(map));
		//图书类别
		session.setAttribute("booktype", bookTypeService.findAll());
		return "index";
	}
	//图书详情
	@RequestMapping("/getBookDetails")
	public String getBookDetails(@RequestParam("id")int id,Map<String, Object> map) {
		map.put("Book",bookService.find(id));
		return "details";

	}

}
