package com.myec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myec.mapper.UserMapper;
import com.myec.pojo.User;
import com.myec.service.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("loginUser");
		if(user == null) {
			String contextUrl = request.getContextPath();
			response.sendRedirect(contextUrl+"/page/login");
			return false;
		}
		User u = userService.getById(user.getId());
		request.getSession().setAttribute("loginUser", u);
		return true;
	}
	
}
