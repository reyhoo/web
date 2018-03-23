package com.grade.mvc.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grade.mvc.mapper.RoleMapper;
import com.grade.mvc.pojo.Role;
import com.grade.mvc.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Value("#{roleMapper}")
	private RoleMapper roleMapper;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int addRole(Role role) {
		return roleMapper.insertRole(role);
	}

	@Override
	public Role getRole(Long id){
		return roleMapper.getRoleById(id);
	}
}
