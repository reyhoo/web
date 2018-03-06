package com.mybatis.plugin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.plugin.pojo.PageParams;
import com.mybatis.plugin.pojo.User;

public interface UserMapper {

	int addUser(User user);
	
	List<User> findAll(PageParams pageParam);
	
	List<User>findWithCondition(@Param("maxId")Long maxId,@Param("minId")Long minId,@Param("page")PageParams pageParam);
}
