package com.mwb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mwb.entity.User;

import com.mwb.service.UserService;

@Controller
@RequestMapping("/static")
public class UserController {

	@Resource
	private UserService userService;
	
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
