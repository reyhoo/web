package com.mvc.exe.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mvc.exe.pojo.User;

@Repository
public interface UserMapper {

	
	User findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	User findById(Long id);
}
