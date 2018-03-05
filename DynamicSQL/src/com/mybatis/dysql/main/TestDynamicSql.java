package com.mybatis.dysql.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dysql.mapper.RoleMapper;
import com.mybatis.dysql.pojo.Role;
import com.mybatis.dysql.utils.SqlSessionFactoryUtils;

public class TestDynamicSql {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		//if
//		List<Role> list = roleMapper.getRoleByRoleName("2");
//		System.out.println(list);
		//choose when otherwise
		Role role = new Role();
		role.setId(1l);
//		role.setRoleName("10");
		List<Role> list = roleMapper.getRoleByBean(role);
		System.out.println(list);
		
	}
}
