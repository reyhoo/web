package com.mybatis.mapper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.mapper.pojo.PageParam;
import com.mybatis.mapper.pojo.Role;

/***
 * select ��ǩ�е��������Ϊ���ʱ�����¼�������ʽ
 * 
 * @author yaolei
 * 
 */
public interface RoleMapper {

	/**
	 * �������Ϊmapʱ,���������put��map��
	 * 
	 * @param map
	 * @return
	 */
	List<Role> findRolesByMap(Map<String, Object> map);

	
	
	
	List<Role> findRolesByAnnotation(@Param("roleName") String roleName,
			@Param("note") String note);
	
	/***
	 * 
	 * @param role
	 * @return
	 */
	List<Role>findRolesByBean(Role role);
	
	
	
	
	List<Role>findRolesByMix(@Param("param")Role role,@Param("page")PageParam pageParam);
}
