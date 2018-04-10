package com.mvc.exe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.exe.mapper.RoleMapper;
import com.mvc.exe.pojo.Role;
import com.mvc.exe.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> findByUserId(Long userId) {
		return roleMapper.findByUserId(userId);
	}
	@Transactional
	@Override
	public int add(Long userId, Role role) {
		return roleMapper.add(userId, role);
	}
	@Transactional
	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}
	@Transactional
	@Override
	public int delete(Long id) {
		return roleMapper.delete(id);
	}

	@Override
	public Role findById(Long id) {
		return roleMapper.findById(id);
	}

}
