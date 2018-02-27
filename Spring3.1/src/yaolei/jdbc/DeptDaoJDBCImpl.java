package yaolei.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DeptDaoJDBCImpl extends JdbcDaoSupport implements DeptDao {

	@Override
	public void save(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dept findById(int id) {
		String sql = "select * from dept where id=?";
		Dept dept = (Dept) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new DeptMappder());
		return dept;
	}

	@Override
	public List<Dept> findAll() {
		String sql = "select * from dept";
		List<Dept> list = getJdbcTemplate().query(sql, new DeptMappder());
		return list;
	}

}
