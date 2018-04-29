package com.myec.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.myec.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	@ResponseBody
	@RequestMapping("/getAll")
	public Map<String , Object> getAll(){
		Map<String , Object>  map = new HashMap<>();
		map.put("datas", testService.getAll());
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String , Object> getById(@PathVariable("id") Long id){
		Map<String , Object>  map = new HashMap<>();
		map.put("data", testService.getById(id));
		return map;
	}
	
}
