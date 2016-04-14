package com.mwb.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mwb.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 所有静态文件
 * 前台 user 拦截器
 */
public class UserInterceptor implements HandlerInterceptor{
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserInterceptor.class);
	//不允许访问页面
	public String[] allowUrls;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("[user] preHandle" );
		String requestUrl = request.getRequestURI().replace(
				request.getContextPath(), "");
		LOGGER.info("URI=" + request.getRequestURI() + " requestUrl= " + requestUrl);
		if (null != allowUrls && allowUrls.length >= 1)
			for (String url : allowUrls) {
				if (requestUrl.equals(url)) {
					User user=(User)request.getSession().getAttribute("user");
					if(user!=null){
						LOGGER.info("user!=null allow uri{}",url);
						return true;
					}else {
						LOGGER.info("user==null no allow uri{}",url);
						response.sendRedirect(request.getContextPath()+"/static/getLogin");
						return false;
					}
				}
			}
		//允许用户访问页面+静态文件放行
		return  true;
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
