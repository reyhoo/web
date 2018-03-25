package com.grade.mvc.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//@EnableWebMvc //配置一对一的converter时要用到<mvc:annotation-driven conversion-service="conversionService"/>,不能重复设置，所以要注释掉
@Configuration
@ComponentScan(basePackages="com.grade.mvc")
public class WebMvcConfig {

	/***
	 * 查找页面的resolver
	 * @return
	 */
	@Bean(name="viewResolver")
	public ViewResolver initViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/page/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	/***
	 * 上传文件的resolver
	 * @return
	 */
	@Bean(name="multipartResolver")
	public MultipartResolver initMultipartResolver(){
		return new StandardServletMultipartResolver();
	}
	
	/***
	 * 
	 * @return
	 */
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
	
	/***
	 * 国际化messageSource，设置资源文件的类
	 * ResourceBundleMessageSource不支持热加载；修改msg文件需要重启才生效
	 * @return
	 */
//	@Bean(name="messageSource")
//	public MessageSource initMessageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasenames("msg");//带路径从classpath算起,后缀通过Locale确定
//		messageSource.setDefaultEncoding("utf-8");
//		return messageSource;
//	}
	/***
	 * 支持热加载，用setCacheSeconds来设置刷新时机
	 * @return
	 */
	@Bean(name="messageSource")
	public MessageSource initMessageSource1(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("/WEB-INF/config/locale/msg");
		messageSource.setDefaultEncoding("utf-8");
		//缓存3600秒，相当于1个小时，然后刷新。默认为-1（不刷新，永远缓存），0代表每次访问国际化文件都刷新
		messageSource.setCacheSeconds(3600);
		//缓存1000*3600毫秒，也是1个小时
//		messageSource.setCacheMillis(1000*3600);
		return messageSource;
	}
	
	/***
	 * 用cookie实现国际化的resolver
	 * @return
	 */
//	@Bean(name="localeResolver")
//	public LocaleResolver initLocaleResolver(){
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setCookieName("lang");
//		//Cookie超时
//		resolver.setCookieMaxAge(1800);
//		//默认使用简体中文
//		resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
//		return resolver;
//	}
//	
	/***
	 * 用session实现国际化的resolver,推荐使用
	 * @return
	 */
	@Bean(name="localeResolver")
	public LocaleResolver initLocaleResolver1(){
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		//默认使用简体中文
		resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return resolver;
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
