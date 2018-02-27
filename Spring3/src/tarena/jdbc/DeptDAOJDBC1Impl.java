package tarena.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DeptDAOJDBC1Impl extends JdbcDaoSupport implements DeptDAO{

	

	public void delete(int id) {
		String sql = "delete from dept where id=?";
		Object[] params = new Object[]{id};
		this.getJdbcTemplate().update(sql,params);
	}

	public Dept findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	public void update(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
