package yaolei.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yaolei.annotation.service.PersonService;

public class AnnotationTest {

	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation-beans.xml");
		PersonService perService = (PersonService) ctx.getBean("personServiceImpl");
		perService.regist();
	}
}
