package com.mybatis2.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis2.mapper.RoleMapper;
import com.mybatis2.mapper.UserMapper;
import com.mybatis2.pojo.Role;
import com.mybatis2.pojo.SexEnum;
import com.mybatis2.pojo.User;
import com.mybatis2.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
//		SqlSession session = SqlSessionFactoryUtils.openSession();
//		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
////		Role role = new Role();
//////		role.setIsStu(true);
////		role.setRoleName("Ò¦gff");
////		role.setNote("Ò¦¹þ¹þÖ»");
////		roleMapper.insert(role);
////		session.commit();
//		List<Role> list = roleMapper.findAll();
//		System.out.println(list);
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		User user = new User();
//		user.setUserName("tom");
//		user.setSex(SexEnum.MALE);
//		userMapper.insert(user);
//		user = new User();
//		user.setUserName("lily");
//		user.setSex(SexEnum.FEMALE);
//		userMapper.insert(user);
//		session.commit();
		System.out.println(userMapper.findAll());
		System.out.println(roleMapper.findAll());
	}
}
