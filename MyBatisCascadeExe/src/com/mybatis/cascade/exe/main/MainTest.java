package com.mybatis.cascade.exe.main;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.cascade.exe.mapper.EmployeeMapper;
import com.mybatis.cascade.exe.pojo.Employee;
import com.mybatis.cascade.exe.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee emp = employeeMapper.getEmployeeById(2l);
		System.err.println(emp);
	}
}
