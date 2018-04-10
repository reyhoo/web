package com.mvc.exe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/page")
@Controller
public class PageController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
