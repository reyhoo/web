package com.myec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class BaseController {

	
	public HttpSession getSession() {
		
		ServletRequestAttributes req = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return req.getRequest().getSession();
	}
	public HttpServletRequest getRequest() {
		ServletRequestAttributes req = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return req.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		ServletRequestAttributes req = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return req.getResponse();
	}
}

