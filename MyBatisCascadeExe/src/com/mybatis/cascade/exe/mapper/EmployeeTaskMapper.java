package com.mybatis.cascade.exe.mapper;

import java.util.List;

import com.mybatis.cascade.exe.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

	List<EmployeeTask> getEmployeeTaskListByEmpId(Long empId);
}
