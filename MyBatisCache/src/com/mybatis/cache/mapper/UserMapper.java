package com.mybatis.cache.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.cache.pojo.User;

public interface UserMapper {

	List<User> findAll();
	User findById(Long id);
	
	int insertUser(@Param("user")User user);
	int updateUser(@Param("user")User user);
	int delete(@Param("id")Long id);
}
