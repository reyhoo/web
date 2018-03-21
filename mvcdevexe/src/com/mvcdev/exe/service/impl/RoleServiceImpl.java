package com.mvcdev.exe.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mvcdev.exe.mapper.RoleMapper;
import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;
	
	
	@Override
	public Role getRole(Long id) {
		return roleMapper.getRoleById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int addRole(Role role) {
		int count = roleMapper.insertRole(role);
		return count;
	}

	@Override
	public List<Role> getRoleList() {
		return roleMapper.getAll();
	}

	@Override
	public List<Role> findRoles(Role role) {
		return roleMapper.findRoles(role);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int deleteRoles(List<Long> ids) {
		return roleMapper.deleteRoles(ids);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int addRoles(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			roleMapper.insertRole(role);
			count++;
		}
		return count;
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
	@Override
	public Role addRole(String roleName, String note) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleMapper.insertRole(role);
		return role;
	}
}
