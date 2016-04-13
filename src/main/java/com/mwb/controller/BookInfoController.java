package com.mwb.controller;

import com.mwb.entity.Book;
import com.mwb.entity.Cart;
import com.mwb.entity.Pagination;
import com.mwb.entity.User;
import com.mwb.service.BookService;
import com.mwb.service.BookTypeService;
import com.mwb.service.CartService;
import com.mwb.service.PaginationService;
import com.mwb.util.FormatDouble;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
	@Autowired
	private CartService cartService;
	// 主页
	@RequestMapping("/index")
	public String index(){
		return  "index";
	}
	// 主页内容
	@RequestMapping("/getShow")
	@ResponseBody
	public Map<String,Object> getShow(HttpServletRequest request){
		LOGGER.info("into  getShow=");
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> result=new HashMap<String, Object>();
		//热销排行 新书排行
		map.put("index",0);
		map.put("size",3);
		//热销书籍
		result.put("hotbooks", bookService.findHotLimit(map));
		//新书
		result.put("newbooks", bookService.findNewLimit(map));
		//图书类别
		result.put("booktypes", bookTypeService.findAll());
		//购物车内容
		User user=(User)request.getSession().getAttribute("user");
		result.put("sum",0);
		result.put("price",0);
		if (user!=null){
			//返回信息
			int sum=0;double price=0;
			List<Cart> list=cartService.find(user);
			for (Cart car : list){
				sum+=car.getNum();
				price+=car.getPrice();
			}
			result.put("sum",sum);
			result.put("price", FormatDouble.getToDoble(price));
		}
		return result;
	}
	//图书详情
	@RequestMapping("/getBookDetails")
	@ResponseBody
	public Book getBookDetails(@RequestParam("id")int id) {
		LOGGER.info("into  getBookDetails=");
		return bookService.find(id);

	}

	//图书类别分页
	@RequestMapping("/getTypeBooksFy")
	@ResponseBody
	public Map<String, Object> getTypeBooksFy(@RequestParam("id")int tyepeid,Pagination page) {
		LOGGER.info("into  getTypeBooks=");
		return PaginationService.Paging(tyepeid,page,bookService,bookTypeService);
	}


}
