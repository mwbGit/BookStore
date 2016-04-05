package com.mwb.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mwb.entity.Book;
import com.mwb.entity.Cart;
import com.mwb.mappers.CartDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mwb.entity.User;

import com.mwb.service.UserService;

@Controller
public class UserController {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private CartDao cartDao;
	@RequestMapping("/test")
	public String Test( User user,HttpServletRequest request){

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		User user1=new  User(1, "mm", "ppp", "啊啊啊", "男", "1203023",
				"email@", "hlj heb", 151257,new Date(), new Date(),0);
		Cart c=new Cart();
		c.setUser(user1);
		Book book= new Book();book.setId(1);
		c.setBook(book);
		c.setNum(10);c.setPrice(1000);
		cartDao.add(c);
		List<Cart> list=cartDao.find(user1);
		//cartDao.delete(1);
		System.out.println(list);
		userService.delete(2);
		userService.edit(user1);
		return "redirect:/test.jsp";
	}
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){

		User resultUser=userService.login(user);
		if(resultUser==null){
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "�û������������");
			return "redirect:/static/login.jsp";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("User", resultUser);
			return "redirect:/static/index.jsp";
			//return "redirect:/success.jsp";
		}
	}

}
