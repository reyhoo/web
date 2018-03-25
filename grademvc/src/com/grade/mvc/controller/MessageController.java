package com.grade.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@RequestMapping("/msgpage")
	public String msgpage(){
		return "msgpage";
	}
}
