package com.gradle.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gradle.mvc.mapper.RoleMapper;
import com.gradle.mvc.pojo.Role;
import com.gradle.mvc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public Role getRoleById(Long id) {
		return roleMapper.getRoleById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insertRole(Role role) {
		return roleMapper.insertRole(role);
	}

	@Override
	public List<Role> getAll() {
		return roleMapper.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int deleteRoles(List<Long> ids) {
		return roleMapper.deleteRoles(ids);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}

}
