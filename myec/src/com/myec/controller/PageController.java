package com.myec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/main")
	public String main() {
		return "mainPage";
	}
}
