package com.jstl.tag.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.*",includeFilters= {@Filter(type=FilterType.ANNOTATION,value=Controller.class)})
public class ServletConfig {

	@Bean(name="viewResolver")
	public ViewResolver initViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/page/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean(name="multipartResolver")
	public MultipartResolver initMultipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1024l*1024*10);
		resolver.setMaxUploadSizePerFile(1024l*1024*5);
		Resource uploadTempDir = new FileSystemResource("D:\\upload\\tmp");
		try {
			resolver.setUploadTempDir(uploadTempDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resolver;
	}
	@Bean(name="requestMappingHandlerAdapter")
	public HandlerAdapter initRequestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		converter.setSupportedMediaTypes(supportedMediaTypes);
		handlerAdapter.getMessageConverters().add(converter);
		return handlerAdapter;
	}
	@Bean(name="messageSource")
	public MessageSource initMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("/WEB-INF/config/locale/msg");
		messageSource.setDefaultEncoding("utf-8");
		//缓存3600秒，相当于1个小时，然后刷新。默认为-1（不刷新，永远缓存），0代表每次访问国际化文件都刷新
		messageSource.setCacheSeconds(3600);
		return messageSource;
	}
	@Bean(name="localeResolver")
	public LocaleResolver initLocaleResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return resolver;
	}
}
