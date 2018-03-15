package com.spring.ass.recode.service;

import java.util.List;

import com.spring.ass.recode.pojo.Role;

public interface RoleService {

	Role getRoleById(Long id);
	List<Role>findAll();
}
