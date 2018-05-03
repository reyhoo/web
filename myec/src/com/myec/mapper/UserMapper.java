package com.myec.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.myec.pojo.User;

@Repository
public interface UserMapper {

	int add(User user);
	User getForLogin(@Param("username") String username,@Param("password")String password);
	User getByUsername(String username);
	User getById(Long id);
}
