package com.mybatis.cascade.main;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.cascade.mapper.EmployeeMapper;
import com.mybatis.cascade.mapper.EmployeeMapper2;
import com.mybatis.cascade.pojo.Employee;
import com.mybatis.cascade.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee emp = employeeMapper.getEmployeeById(1l);
		System.err.println(emp);
		emp = employeeMapper.getEmployeeById(1l);
		System.err.println(emp);
		
		EmployeeMapper2 employeeMapper2 =  session.getMapper(EmployeeMapper2.class);
		emp = employeeMapper2.getEmployeeById(1l);
		System.out.println(emp);
	}
}
