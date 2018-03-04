package com.mybatis.cascade.exe.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mybatis.cascade.exe.mapper.EmployeeMapper;
import com.mybatis.cascade.exe.pojo.Employee;
import com.mybatis.cascade.exe.utils.SqlSessionFactoryUtils;

public class MainTest {

	static Logger sLogger = Logger.getLogger(MainTest.class);
	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee emp = employeeMapper.getEmployeeById(2l);
//		sLogger.info("=============================================");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.err.println(emp.getEmail());
//		sLogger.info("=============================================");
////		try {
////			Thread.sleep(2000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//		emp.getEmployeeTaskList().get(0);
//		
//		try {
//		Thread.sleep(2000);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
//		emp.getEmployeeTaskList().get(0).getTask();
		System.err.println();
	}
}
