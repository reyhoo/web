package com.mybatis.mapper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.mybatis.mapper.pojo.PageParam;
import com.mybatis.mapper.pojo.Role;

/***
 * select 标签中当传入参数为多个时有以下几个处理方式
 * 
 * @author yaolei
 * 
 */
public interface RoleMapper {

	
	
	
	int insertRoleWithCustomId(@Param("role")Role role);
	
	/***
	 * 在映射xml中用useGeneratedKeys属性设置获取id,回传到role的id属性中
	 * @param role
	 * @return
	 */
	int insertRole(@Param("role")Role role);
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
	
	/**
	 * 用RowBounds实现分页，这种方式适合是把全量数据查询出来，然后再在结果集中取出想要的数据，适合数据量小的情况
	 * @param roleName
	 * @param note
	 * @param rowBounds
	 * @return
	 */
	List<Role>findRolesByBounds(@Param("roleName")String roleName,@Param("note")String note,RowBounds rowBounds);
}
