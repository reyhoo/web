package yaolei.sqlmapper;

import yaolei.mapper.RoleMapper;
import yaolei.pojo.Role;
import yaolei.pojo.SqlSessionFactoryUtil;

public class SqlMapperTest {

	
	public static void main(String[] args) {
		RoleMapper roleMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(RoleMapper.class);
		Role role = roleMapper.getRole(1l);
		System.out.println(role);
	}
}
