package yaolei.aop.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yaolei.aop.annotation.service.DeptService;

public class TestAnnotationAspect {

	
	public static void main(String[] args) {
		
		ApplicationContext act = new ClassPathXmlApplicationContext("aop-annotation-bean.xml");
		DeptService deptService = (DeptService) act.getBean("deptService");
		deptService.save();
		deptService.delete();
	}
}
