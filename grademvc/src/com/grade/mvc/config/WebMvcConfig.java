package com.grade.mvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//@EnableWebMvc //配置一对一的converter时要用到<mvc:annotation-driven conversion-service="conversionService"/>,不能重复设置，所以要注释掉
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
	
	
	//用注解httpMessageConverter转换器
	@Bean(name="requestMappingHandlerAdapter")
	public HandlerAdapter initRequestMappingHandlerAdapter(){
		//创建适配器
		RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
		//http json转换器
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
		List<MediaType>mediaTypes = new ArrayList<>();
		mediaTypes.add(mediaType);
		jsonConverter.setSupportedMediaTypes(mediaTypes);
		rmha.getMessageConverters().add(jsonConverter);
		return rmha;
	}
	
	
	
	//用注解配置一对一的converter貌似不可行
//	@Autowired
//	private FormattingConversionServiceFactoryBean fcsfb = null;
//	
//	private List<Converter>myConverter = null;
//	
//	
//	@Bean(name="myConverter")
//	public List<Converter> initMyConverter(){
//		if(myConverter == null){
//			myConverter = new ArrayList<Converter>();
//		}
//		Converter<String, Role> roleConverter = new StringToRoleConverter();
//		myConverter.add(roleConverter);
//		fcsfb.getObject().addConverter(roleConverter);
//		return myConverter;
//	}

}
