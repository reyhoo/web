package com.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/my")
public class MyController {

	static Logger log = Logger.getLogger(MyController.class);
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/index2")
	public ModelAndView index2(@RequestParam(name="name",required=false, defaultValue="Ò¦ÀÚ")String id,@SessionAttribute(name="userName")String userName){
		log.info("name:"+id);
		log.info("userName:"+userName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
