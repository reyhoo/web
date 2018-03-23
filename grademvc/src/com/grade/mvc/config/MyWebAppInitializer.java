package com.grade.mvc.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		String filePath = "d:\\mvc\\grade\\uploads";
		Long singleMax = (long) (5 * Math.pow(2, 20));
		Long totalMax = (long) (10 * Math.pow(2, 20));
		registration.setMultipartConfig(new MultipartConfigElement(filePath, singleMax, totalMax, 0));
	}

}
