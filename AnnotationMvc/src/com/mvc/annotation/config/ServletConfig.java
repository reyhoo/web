package com.mvc.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.mvc.annotation")
@EnableWebMvc
public class ServletConfig{

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
//	@Bean(name="multipartResolver")
//	public MultipartResolver initMultipartResolver(){
//		String filePath = "d:\\mvc\\uploads";
//		Long singleMax = (long) (5 * Math.pow(2, 20));
//		Long totalMax = (long) (10 * Math.pow(2, 20));
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSizePerFile(singleMax);
//		multipartResolver.setMaxUploadSize(totalMax);
//		try {
//			multipartResolver.setUploadTempDir(new FileSystemResource(filePath));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return multipartResolver;
//	}

}
