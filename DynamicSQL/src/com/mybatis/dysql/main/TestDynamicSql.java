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
		List<Role> list = roleMapper.getRoleByRoleName("2");
		System.out.println(list);
		
		
	}
}
