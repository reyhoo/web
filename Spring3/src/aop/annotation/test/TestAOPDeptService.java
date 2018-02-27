package aop.annotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.annotation.service.DeptService;

public class TestAOPDeptService {
	@Test
	public void testAOPTimeHander(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-annotation-bean.xml");
		DeptService deptService = (DeptService)ctx.getBean("deptService");
		deptService.save();
		deptService.delete();
	}
}
