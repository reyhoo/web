package com.grade.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@RequestMapping("/msgpage")
	public String msgpage(){
		return "msgpage";
	}
}
