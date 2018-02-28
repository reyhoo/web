package com.yaolei.mybatis.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.yaolei.mybatis.mapper.RoleMapper;
import com.yaolei.mybatis.pojo.Role;
import com.yaolei.mybatis.utils.SqlSessionFactoryUtils;

public class MyBatisMain {

	
	public static void main(String[] args) {
		Logger log = Logger.getLogger(MyBatisMain.class);
		SqlSession sqlSession = null;
		try{
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			
//			Role role = roleMapper.getRole(1l);
//			log.debug(role);
			
			Role role = new Role();
			role.setNote("Ҧ�ڱ�ע��ע");
			role.setRoleName("Ҧ��");
			try {
				int count = roleMapper.insertRole(role);
				System.out.println(count);
				sqlSession.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Role> list = roleMapper.findRoles("Ҧ");
			
//			list.get(0).setRoleName("Ҧ��������");
			
			roleMapper.deleteRole(list.get(0).getId());
//			roleMapper.updateRole(list.get(0));
			sqlSession.commit();
			log.error(list);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
