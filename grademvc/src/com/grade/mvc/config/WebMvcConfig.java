package com.grade.mvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.grade.mvc")
public class WebMvcConfig {

	
	@Bean(name="viewResolver")
	public ViewResolver initViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/page/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean(name="multipartResolver")
	public MultipartResolver initMultipartResolver(){
		return new StandardServletMultipartResolver();
	}
	
//	@Bean(name="requestMappingHandlerAdapter")
//	public HandlerAdapter initRequestMappingHandlerAdapter(){
//		//´´½¨ÊÊÅäÆ÷
//		RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
//		//http json×ª»»Æ÷
//		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//		MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
//		List<MediaType>mediaTypes = new ArrayList<>();
//		mediaTypes.add(mediaType);
//		jsonConverter.setSupportedMediaTypes(mediaTypes);
//		rmha.getMessageConverters().add(jsonConverter);
//		return rmha;
//	}
}
