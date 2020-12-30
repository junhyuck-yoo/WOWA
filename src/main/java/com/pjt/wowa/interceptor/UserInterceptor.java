package com.pjt.wowa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("login check");
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null) {
			logger.info("need to login, return login page");
			response.sendRedirect("/member/login");
			return false;
		}else {
			logger.info("login check success");
			return true;
		}
		
	}

}
