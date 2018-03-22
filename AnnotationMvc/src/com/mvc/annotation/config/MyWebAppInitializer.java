package com.mvc.annotation.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		String filePath = "d:\\mvc\\uploads";
		Long singleMax = (long) (5 * Math.pow(2, 20));
		Long totalMax = (long) (10 * Math.pow(2, 20));
		registration.setMultipartConfig(new MultipartConfigElement(filePath, singleMax, totalMax, 0));
	}

}
