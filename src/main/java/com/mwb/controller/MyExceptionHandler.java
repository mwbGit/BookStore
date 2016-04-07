package com.mwb.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常控制
 * 跳转页面
 */
@ControllerAdvice
public class MyExceptionHandler {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@ExceptionHandler({Exception.class})
	public ModelAndView Exception(Exception ex){
		LOGGER.info("into ExceptionHandler");
		LOGGER.error("出错了异常",ex);
		ModelAndView mv = new ModelAndView("err");
		mv.addObject("exception", ex);
		return mv;
	}
	
}
