package com.mybatis.hole.main;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.hole.mapper.EmployeeMapper;
import com.mybatis.hole.pojo.Employee;
import com.mybatis.hole.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		EmployeeMapper employeeMapper =  session.getMapper(EmployeeMapper.class);
		Employee employee = employeeMapper.getEmployeeById(3l);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employee.getEmployeeTaskList();
	}
}
