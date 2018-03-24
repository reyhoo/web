package com.grade.mvc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	/**
	 * 表单两个input的name相同时，接收参数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/submit1")
	public Object submit1(@RequestParam("name")List<String>names){
		System.err.println(names);
		return names;
	}
	/***
	 * json发送原文接收,原文响应
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/submit2")
	public Object submit2(@RequestBody String info,HttpServletResponse response){
		System.err.println("info:"+info);
		System.err.println("response:"+response);
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("info", info);
		return map;
	}
}
