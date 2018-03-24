package com.grade.mvc.service.impl;

import java.util.List;

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
	public Integer addRole(Role role) {
		return roleMapper.insertRole(role);
	}

	@Override
	public Role getRole(Long id){
		return roleMapper.getRoleById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Integer updateRole(Role role) {
		return roleMapper.updateRole(role);
	}

	@Override
	public List<Role> getAll() {
		return roleMapper.getAll();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Integer updateRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			count += roleMapper.updateRole(role);
		}
		return count;
	}
}
