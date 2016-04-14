package com.mwb.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mwb.entity.Admin;
import com.mwb.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台 admin 拦截器
 */
public class AdminInterceptor implements HandlerInterceptor{
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AdminInterceptor.class);
	//允许访问页面
	public String[] allowUrls;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("Admin preHandle uri=" + request.getRequestURI());
		String requestUrl = request.getRequestURI().replace(
				request.getContextPath(), "");
		LOGGER.info(" requestUrl: " + requestUrl);
		if (null != allowUrls && allowUrls.length >= 1)
			for (String url : allowUrls) {
				System.out.println("url: " + url);
				if (requestUrl.equals(url)) {
					LOGGER.info("allow uri{}",requestUrl);
					return true;
				}
			}
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		if(admin!=null){
			LOGGER.info("admin!=null");
			return true;
		}else {
			LOGGER.info("admin==null");
			response.sendRedirect(request.getContextPath()+"/static/manager/adminlogin");
			return false;
		}
	}


	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}


	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
