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


//@EnableWebMvc //����һ��һ��converterʱҪ�õ�<mvc:annotation-driven conversion-service="conversionService"/>,�����ظ����ã�����Ҫע�͵�
@Configuration
@ComponentScan(basePackages="com.grade.mvc")
public class WebMvcConfig {

	/***
	 * ����ҳ���resolver
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
	 * �ϴ��ļ���resolver
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
	//��ע��httpMessageConverterת����
	@Bean(name="requestMappingHandlerAdapter")
	public HandlerAdapter initRequestMappingHandlerAdapter(){
		//����������
		RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
		//http jsonת����
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
		List<MediaType>mediaTypes = new ArrayList<>();
		mediaTypes.add(mediaType);
		jsonConverter.setSupportedMediaTypes(mediaTypes);
		rmha.getMessageConverters().add(jsonConverter);
		return rmha;
	}
	
	/***
	 * ���ʻ�messageSource��������Դ�ļ�����
	 * ResourceBundleMessageSource��֧���ȼ��أ��޸�msg�ļ���Ҫ��������Ч
	 * @return
	 */
//	@Bean(name="messageSource")
//	public MessageSource initMessageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasenames("msg");//��·����classpath����,��׺ͨ��Localeȷ��
//		messageSource.setDefaultEncoding("utf-8");
//		return messageSource;
//	}
	/***
	 * ֧���ȼ��أ���setCacheSeconds������ˢ��ʱ��
	 * @return
	 */
	@Bean(name="messageSource")
	public MessageSource initMessageSource1(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("/WEB-INF/config/locale/msg");
		messageSource.setDefaultEncoding("utf-8");
		//����3600�룬�൱��1��Сʱ��Ȼ��ˢ�¡�Ĭ��Ϊ-1����ˢ�£���Զ���棩��0����ÿ�η��ʹ��ʻ��ļ���ˢ��
		messageSource.setCacheSeconds(3600);
		//����1000*3600���룬Ҳ��1��Сʱ
//		messageSource.setCacheMillis(1000*3600);
		return messageSource;
	}
	
	/***
	 * ��cookieʵ�ֹ��ʻ���resolver
	 * @return
	 */
//	@Bean(name="localeResolver")
//	public LocaleResolver initLocaleResolver(){
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setCookieName("lang");
//		//Cookie��ʱ
//		resolver.setCookieMaxAge(1800);
//		//Ĭ��ʹ�ü�������
//		resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
//		return resolver;
//	}
//	
	/***
	 * ��sessionʵ�ֹ��ʻ���resolver,�Ƽ�ʹ��
	 * @return
	 */
	@Bean(name="localeResolver")
	public LocaleResolver initLocaleResolver1(){
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		//Ĭ��ʹ�ü�������
		resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return resolver;
	}
	
	
	
	
	
	
	//��ע������һ��һ��converterò�Ʋ�����
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
