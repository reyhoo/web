package com.mvcdev.exe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/requestParam")
	public String request(){
		return "request";
	}
	@RequestMapping("/sendJson")
	public String sendJson(){
		return "sendJson";
	}
}
