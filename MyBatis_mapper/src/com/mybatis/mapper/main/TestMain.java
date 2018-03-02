package com.mybatis.mapper.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.mapper.mapper.RoleMapper;
import com.mybatis.mapper.pojo.PageParam;
import com.mybatis.mapper.pojo.Role;
import com.mybatis.mapper.utils.SqlSessionFactoryUtils;

public class TestMain {

	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("roleName", "roleNamevalues");
//		map.put("note", "notenotenotes");
//		roleMapper.findRolesByMap(map);
//		
		

		//		roleMapper.findRolesByAnnotation("findRolesByAnnotation", "findRolesByAnnotationnote");
		Role role = new Role();
		role.setRoleName("findRolesByMix");
		role.setNote("findRolesByMixnote");
//		roleMapper.findRolesByBean(role);
		PageParam page = new PageParam();
		page.setLimit(5);
		page.setStart(0);
		roleMapper.findRolesByMix(role, page);
		session.close();
	}
	
}
