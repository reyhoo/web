package com.jstl.tag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jstl.tag.pojo.User;
@Repository
public interface UserMapper {

	List<User>getAll(@Param("start")int start,@Param("limit")int limit);
	
	int getCount();
	
	User getUser(Long id);
}
