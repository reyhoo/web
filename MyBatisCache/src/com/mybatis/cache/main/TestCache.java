package com.mybatis.cache.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.cache.mapper.RoleMapper;
import com.mybatis.cache.mapper.UserMapper;
import com.mybatis.cache.pojo.Role;
import com.mybatis.cache.utils.SqlSessionFactoryUtils;

public class TestCache {

	
	public static void main(String[] args) {
		SqlSession session1 = SqlSessionFactoryUtils.openSession();
		RoleMapper roleMapper1 = session1.getMapper(RoleMapper.class);
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		
		
		SqlSession session2 = SqlSessionFactoryUtils.openSession();
		RoleMapper roleMapper2 = session2.getMapper(RoleMapper.class);
		UserMapper userMapper2 = session2.getMapper(UserMapper.class);
		//
		System.out.println("=======================================");
		List<Role> list = roleMapper1.findAll();
		System.out.println(list.size());
		userMapper1.findAll();
//		System.out.println("=======================================");
//		roleMapper2.findAll();
//		userMapper2.findAll();
//		System.out.println("=======================================");
//		Role role = new Role();
//		role.setNote("yaoleinoet");
//		role.setRoleName("tintintint");
////		role.setId(2l);
//		roleMapper1.insertRole(role);
////		roleMapper1.delete(null);
//		
		
//		System.out.println(list.size());
		session1.commit();
		list = roleMapper1.findAll();
////		session1.rollback();
//		System.out.println("id="+role.getId());
//		System.out.println(list.size());
//		list = roleMapper1.findAll();
//		System.out.println(list.size());
		userMapper1.findAll();
//		System.out.println("=======================================");
//		roleMapper2.findAll();
//		userMapper2.findAll();
//		System.out.println("=======================================");
		
	}
}
