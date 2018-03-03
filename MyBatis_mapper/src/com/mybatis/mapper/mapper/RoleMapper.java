package com.mybatis.mapper.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.mybatis.mapper.pojo.PageParam;
import com.mybatis.mapper.pojo.Role;

/***
 * select ��ǩ�е��������Ϊ���ʱ�����¼�������ʽ
 * 
 * @author yaolei
 * 
 */
public interface RoleMapper {

	
	
	
	int insertRoleWithCustomId(@Param("role")Role role);
	
	/***
	 * ��ӳ��xml����useGeneratedKeys�������û�ȡid,�ش���role��id������
	 * @param role
	 * @return
	 */
	int insertRole(@Param("role")Role role);
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
	
	/**
	 * ��RowBoundsʵ�ַ�ҳ�����ַ�ʽ�ʺ��ǰ�ȫ�����ݲ�ѯ������Ȼ�����ڽ������ȡ����Ҫ�����ݣ��ʺ�������С�����
	 * @param roleName
	 * @param note
	 * @param rowBounds
	 * @return
	 */
	List<Role>findRolesByBounds(@Param("roleName")String roleName,@Param("note")String note,RowBounds rowBounds);
}
