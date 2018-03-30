package com.annotation.redis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.annotation.redis.mapper.RoleDao;
import com.annotation.redis.pojo.Role;
import com.annotation.redis.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Cacheable(value="redisCacheManager",key="'redis_role_'+#id")
	public Role getRole(Long id) {
		return roleDao.getRole(id);
	}

	@Override
	public int deleteRole(Long id) {
		return 0;
	}
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@CachePut(value="redisCacheManager",key="'redis_role_'+#result.id")
	@Override
	public Role insertRole(Role role) {
		roleDao.insertRole(role);
		return role;
	}
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@CachePut(value="redisCacheManager",key="'redis_role_'+#role.id")
	@Override
	public Role updateRole(Role role) {
		roleDao.updateRole(role);
		return role;
	}

	@Override
	public List<Role> findRoles(String roleName, String note) {
		// TODO Auto-generated method stub
		return null;
	}

}
