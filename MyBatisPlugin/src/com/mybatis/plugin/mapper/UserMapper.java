package com.mybatis.plugin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.plugin.plugin.PageParam;
import com.mybatis.plugin.pojo.User;

public interface UserMapper {

	int addUser(User user);
	
	List<User> findAll(PageParam pageParam);
	
	List<User>findWithCondition(@Param("maxId")Long maxId,@Param("minId")Long minId,PageParam pageParam);
}
