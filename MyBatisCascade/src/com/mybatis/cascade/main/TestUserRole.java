package com.mybatis.cascade.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.cascade.mapper.RoleMapper;
import com.mybatis.cascade.mapper.UserMapper;
import com.mybatis.cascade.pojo.Role;
import com.mybatis.cascade.pojo.User;
import com.mybatis.cascade.utils.SqlSessionFactoryUtils;

public class TestUserRole {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		User user = userMapper.findUser(3l);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		List<Role> list = user.getRoleList();
//		for (Role role : list) {
//			System.out.println(role.getRoleName());
//			
//		}
		
		System.out.println("=========================================");
		
		testRole(roleMapper);
//		Role role = roleMapper.findRole(1l);
//		System.out.println(role.getRoleName());
	}
	static void testRole( RoleMapper roleMapper){
		Role role = roleMapper.findRole(10l);
		System.out.println(role.getRoleName());
		role.getUserList();
		System.out.println();
	}
}
