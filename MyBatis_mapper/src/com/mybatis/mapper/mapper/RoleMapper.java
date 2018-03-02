package com.mybatis.mapper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.mapper.pojo.PageParam;
import com.mybatis.mapper.pojo.Role;

/***
 * select 标签中当传入参数为多个时有以下几个处理方式
 * 
 * @author yaolei
 * 
 */
public interface RoleMapper {

	/**
	 * 传入参数为map时,将多个参数put进map里
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
