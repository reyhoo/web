package com.mybatis.cascade.mapper;

import org.apache.ibatis.annotations.Param;

import com.mybatis.cascade.pojo.WorkCard;

public interface WorkCardMapper {

	WorkCard getWorkCardByEmpId(Long empId);
}
