package com.mybatis.cache.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.cache.mapper.RoleMapper;
import com.mybatis.cache.pojo.Role;
import com.mybatis.cache.utils.SqlSessionFactoryUtils;

public class TestCache {

	
	public static void main(String[] args) {
		SqlSession session1 = SqlSessionFactoryUtils.openSession();
		RoleMapper roleMapper = session1.getMapper(RoleMapper.class);
		Role role = roleMapper.findById(1l);
//		 roleMapper.findById(1l);
		System.out.println(role);
		role.setRoleName("fadfadfa");
		roleMapper.updateRole(role);
//		session1.rollback();
		System.out.println(roleMapper.findById(1l));
		
		new Thread(){
			public void run() {
				SqlSession session1 = SqlSessionFactoryUtils.openSession();
				RoleMapper roleMapper = session1.getMapper(RoleMapper.class);
				Role role = new Role();
				role.setId(1l);
				role.setNote("note12121");
				System.err.println("=================start=================");
				roleMapper.updateRole(role);
				System.err.println("=================end=================");
				System.err.println(roleMapper.findById(1l));
			}
		}.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		session1.close();
	}
}
