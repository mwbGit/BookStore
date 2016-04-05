package com.mwb.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mwb.entity.*;
import com.mwb.mappers.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mwb.service.UserService;

@Controller
public class UserController {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private OderDao oderDao;
	@Autowired
	private OderDetailsDao oderDetailsDao;
	@RequestMapping("/test")
	public String Test( User user,HttpServletRequest request){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		User user1=new  User(1,"mm","ppp","啊啊啊","男","1203023",
				"email@", "hlj heb", 151257,new Date(), new Date(),0);

		Book book=new  Book("java", new BookType(1,"mwb"),"heidachubanshe",
				new Date(), "mwb", "aaaaaaaaaaaa",11.3,10.2,100) ;
		user1.setId(1);
		oderDao.add(new Oder("hlj", new Date(), "mwb", 10, 1.2, "bbb",user1));
		List<Oder> list1=oderDao.find(user1);
		List<OderDetails> list=oderDetailsDao.findAll();
		book.setId(5);
		oderDetailsDao.add(new OderDetails(book,10,list1.get(0),10.3,11));
		List<OderDetails> list2=oderDetailsDao.find(1);
		//oderDetailsDao.delete(1);
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
