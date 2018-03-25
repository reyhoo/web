package com.gradle.mvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;

import com.gradle.mvc.pojo.FormatPojo;

@Controller
@RequestMapping("/format")
public class FormatController {
	/***
	 * 如果不传不会报错；如果格式错误报错；
	 * 加上RequestParam注解就是必传的了
	 * @param date1
	 * @param amount1
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/test")
	public Map<String, Object> test(Date date1,@NumberFormat(pattern="#,###.00")Double amount1){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("date", date1+"");
		map.put("amount", amount1+"");
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/testPojo")
	public Map<String, Object> testPojo(@Valid FormatPojo formatPojo){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("date", formatPojo.getDate1()+"");
		map.put("amount", formatPojo.getAmount1()+"");
		return map;
	}
}
