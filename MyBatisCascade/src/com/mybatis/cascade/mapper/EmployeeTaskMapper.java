package com.mybatis.cascade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.cascade.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

	List<EmployeeTask> getEmployeeTaskListByEmpId(Long empId);
}
