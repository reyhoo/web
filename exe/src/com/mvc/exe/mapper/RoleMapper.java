package com.mvc.exe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mvc.exe.pojo.Role;

@Repository
public interface RoleMapper {


	List<Role>findByUserId(Long userId);
	
	int add(@Param("userId")Long userId,@Param("role")Role role);
	
	int update(Role role);
	
	int delete(Long id);
	
	Role findById(Long id);
	
	int savePic(Role role);
}
