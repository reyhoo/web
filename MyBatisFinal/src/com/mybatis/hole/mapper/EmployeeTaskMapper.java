package com.mybatis.hole.mapper;

import java.util.List;

import com.mybatis.hole.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

	
	List<EmployeeTask> getEmployeeTaskListByEmpId(Long empId);
	
}
