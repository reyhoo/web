package com.mybatis.dysql.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dysql.mapper.RoleMapper;
import com.mybatis.dysql.pojo.Role;
import com.mybatis.dysql.pojo.SexEnum;
import com.mybatis.dysql.pojo.User;
import com.mybatis.dysql.utils.SqlSessionFactoryUtils;

public class TestDynamicSql {

	
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		//if
//		List<Role> list = roleMapper.getRoleByRoleName("2");
//		System.out.println(list);
		
		
		
		
		//choose when otherwise
//		Role role = new Role();
//		role.setId(1l);
////		role.setRoleName("10");
//		List<Role> list = roleMapper.getRoleByBean(role);
//		System.out.println(list);
		
		
		
//		//where
//		List<Role> list = roleMapper.findsRoles("dsfasdfasd", "role0");
//		System.out.println(list);
		
		//trim
//		List<Role> list = roleMapper.findsRolesByTrim("dfd", "role22222");
//		System.out.println(list);
		
		
		//set
//		Role role = new Role();
//		role.setId(1l);
//		role.setNote("Ò¦ÀÚnote");
//		roleMapper.updateRoleByTrim(role);
//		session.commit();
		
		//trim as set
//		User user = new User();
////		user.setNote("yaoleiyaoleoyaolei");
//		user.setSex(SexEnum.MALE);
//		user.setId(1l);
//		roleMapper.updateUser(user);
//		session.commit();
		
		
		//foreach
//		List<Role>list = new ArrayList<Role>();
//		Role role = new Role();
//		role.setId(1l);
//		list.add(role);
//		role = new Role();
//		role.setId(2l);
//		list.add(role);
//		role = new Role();
//		role.setId(3l);
//		list.add(role);
//		System.out.println(roleMapper.findRolesByList(list));
		
//		List<Long>list = new ArrayList<Long>();
//		list.add(1l);
//		list.add(2l);
//		list.add(3l);
//		System.out.println(roleMapper.findRolesByIdList(list));
		
		//bind
		System.out.println(roleMapper.findRolesByBind("l", "ÀÚ"));
	}
}
