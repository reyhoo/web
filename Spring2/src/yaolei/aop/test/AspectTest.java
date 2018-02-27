package yaolei.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yaolei.aop.service.DeptService;

public class AspectTest {

	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("aop-beans.xml");
		DeptService deptService = (DeptService) act.getBean("deptService");
		deptService.save();
	}
}
