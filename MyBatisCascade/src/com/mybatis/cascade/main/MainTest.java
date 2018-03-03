package com.mybatis.cascade.main;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.cascade.mapper.EmployeeMapper;
import com.mybatis.cascade.pojo.Employee;
import com.mybatis.cascade.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee emp = employeeMapper.getEmployeeById(1l);
		System.err.println(emp);
	}
}
