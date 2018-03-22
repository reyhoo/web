package com.mvc.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/request")
	public String request(){
		return "request";
	}
}
