package com.mybatis.cascade.mapper;

import org.apache.ibatis.annotations.Param;

import com.mybatis.cascade.pojo.Task;

public interface TaskMapper {

	Task getTask(Long taskId);
}
