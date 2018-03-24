package com.grade.mvc.advice;

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
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages="com.grade.mvc.advice")
public class CommonControllerAdvice {

	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	@ModelAttribute
	public void populateModel(Model model){
		model.addAttribute("projectName", "grademvc");
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Model model,Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter  out = new PrintWriter(sw);
		e.printStackTrace(out);
		out.flush();
		model.addAttribute("errInfo", sw.toString());
		model.addAttribute("exception", e);
		return "exception";
	}
	
}
