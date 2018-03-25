package com.gradle.mvc.controller;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/form")
	public String form() {
//		FormattingConversionServiceFactoryBean b = null;b.setConverters(converters);
//		InternalResourceViewResolver r = null;
//		r.setPrefix("/WEB-INF/page/");
//		r.setSuffix(".jsp");
//		CommonsMultipartResolver r = null;
//		r.setMaxUploadSize(maxUploadSize);
//		r.setMaxUploadSizePerFile(maxUploadSizePerFile);
//		r.setUploadTempDir(uploadTempDir);
//		SessionLocaleResolver f = null;f.setDefaultLocale(defaultLocale);
//		ReloadableResourceBundleMessageSource s = null;s.setCacheMillis(cacheMillis);
//		LocaleChangeInterceptor c = null;c.setParamName(paramName);
//		RequestMappingHandlerAdapter a =null;a.setMessageConverters(messageConverters);
//		MappingJackson2HttpMessageConverter cc = null;cc.setSupportedMediaTypes(supportedMediaTypes);
//		SqlSessionFactoryBean b = null;
//		b.setConfigLocation(configLocation);
//		DataSourceTransactionManager
//		MapperScannerConfigurer c = null;
//		c.setAnnotationClass(annotationClass);
//		c.setSqlSessionFactoryBeanName(sqlSessionFactoryName);
//		c.setBasePackage(basePackage);
		return "form";
	}
}
