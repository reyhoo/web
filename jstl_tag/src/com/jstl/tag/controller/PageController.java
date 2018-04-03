package com.jstl.tag.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@RequestMapping("/format")
	public String format(Model model) {
		model.addAttribute("date", new Date());
		model.addAttribute("num", 1234232.2121d);
		return "format";
	}
}
