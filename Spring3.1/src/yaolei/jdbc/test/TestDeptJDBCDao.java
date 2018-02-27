package yaolei.jdbc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yaolei.jdbc.Dept;
import yaolei.jdbc.DeptDao;

public class TestDeptJDBCDao {

	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("annotation-beans.xml");
		DeptDao deptDao = (DeptDao) cxt.getBean("deptDao");
		List<Dept> list = deptDao.findAll();
		System.out.println(list);
	}
}
