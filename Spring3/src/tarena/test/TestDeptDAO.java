package tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tarena.jdbc.Dept;
import tarena.jdbc.DeptDAO;

public class TestDeptDAO {
//	@Test
	public void testAddDept(){
		Dept dept = new Dept();
		dept.setDname("财务部");
		dept.setLoc("北京金融街");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-bean.xml");
		DeptDAO deptDao = (DeptDAO)ctx.getBean("deptDao");
		deptDao.save(dept);
		}
	
//	@Test
	public void testFindByID(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-bean.xml");
		DeptDAO deptDao = (DeptDAO)ctx.getBean("deptDao");
		Dept dept = deptDao.findById(3);
		System.out.println(dept.getDname()+" "+dept.getLoc());
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-bean.xml");
		DeptDAO deptDao = (DeptDAO)ctx.getBean("deptDao");
		List<Dept> list = deptDao.findAll();
		for(Dept dept : list){
			System.out.println(dept.getId() + " "+dept.getDname() + " "+dept.getLoc());
		}
	}
	
	
}
