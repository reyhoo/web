package yaolei.sqlsession;

import org.apache.ibatis.session.SqlSession;

import yaolei.pojo.Role;
import yaolei.pojo.SqlSessionFactoryUtil;

public class SqlSessionTest {

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
			Role role = session.selectOne("yaolei.mapper.RoleMapper.getRole", 1l);
			System.out.println(role);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}
}
