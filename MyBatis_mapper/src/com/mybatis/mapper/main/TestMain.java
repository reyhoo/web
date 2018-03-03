package com.mybatis.mapper.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
		
		RowBounds rowBounds = new RowBounds(0,5);
		List<Role> list = roleMapper.findRolesByBounds("findRolesByBounds", "findRolesByBoundsnote",rowBounds);
		System.out.println(list);

		//		Role role = new Role();
//		role.setRoleName("findRolesByMix");
//		role.setNote("findRolesByMixnote");
////		roleMapper.findRolesByBean(role);
//		PageParam page = new PageParam();
//		page.setLimit(5);
//		page.setStart(0);
//		roleMapper.findRolesByMix(role, page);
//		session.close();
		
		Role role = new Role();
		role.setNote("tom note");
		role.setRoleName("tom4");
		roleMapper.insertRole(role);
		session.commit();
		
		System.out.println(role.getId());
	}
	
}
