package com.myec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myec.pojo.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("loginUser");
		if(user == null) {
			String contextUrl = request.getContextPath();
			response.sendRedirect(contextUrl+"/page/login");
			return false;
		}
		return true;
	}
	
}
