package com.gradle.mvc.advice;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages="com.gradle.mvc.controller")
public class MyAdvice {

	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), false));
	}
	@ExceptionHandler(Exception.class)
	public String exception(Exception e,Model model){
		StringWriter sw = new StringWriter();
		PrintWriter  out = new PrintWriter(sw);
		e.printStackTrace(out);
		out.flush();
		model.addAttribute("errInfo", sw.toString());
		model.addAttribute("exception", e);
		return "exception";
	}
}
