package com.grade.mvc.advice.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/advice")
public class MyAdviceController {

	/***
	 * 
	 * @param model
	 *            从模型里可能获取在@CommonControllerAdvice通知ModelAttribute注解的方法设置的参数
	 * @param date
	 *            在@CommonControllerAdvice中InitBinder注解的方法已经注册过日期格式化器了
	 *            ，所以不用再使用注解DateTimeFormat
	 * @param amount
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> testAdvice(Model model, Date date,
			@NumberFormat(pattern = "#,###.00")@RequestParam BigDecimal amount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date.toString());
		map.put("amount", amount);
		map.put("project_name", model.asMap().get("projectName"));
		return map;
	}

	@RequestMapping("/exception")
	public String exception() {
		throw new RuntimeException("测试异常跳转");
	}
	
}
