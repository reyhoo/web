package com.mybatis.cascade.mapper;

import java.util.List;

import com.mybatis.cascade.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

	List<EmployeeTask> getEmployeeTaskListByEmpId(Long empId);
}