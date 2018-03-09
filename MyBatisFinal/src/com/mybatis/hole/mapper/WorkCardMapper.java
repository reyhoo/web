package com.mybatis.hole.mapper;

import com.mybatis.hole.pojo.WorkCard;

public interface WorkCardMapper {

	WorkCard getWorkCardByEmpId(Long empId);
	
}
