package yaolei.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class DeptJDBCDaoImpl implements DeptDao {
	private JdbcTemplate template;//增删改查工具类
	public void setDataSource(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Dept dept) {
		String sql = "insert into dept (dname,loc) value(?,?)";
		template.update(sql, new Object[]{dept.getDname(),dept.getLoc()});
	}

	@Override
	public void delete(int id) {
		String sql = "delete from dept where id=?";
		template.update(sql,new Object[]{id});

	}

	@Override
	public void update(Dept dept) {
		String sql = "update dept set dname=?,loc=? where id=?";
		template.update(sql,new Object[]{dept.getDname(),dept.getLoc(),dept.getId()});
	}

	@Override
	public Dept findById(int id) {
		String sql = "select * from dept where id=?";
		Dept dept = (Dept) template.queryForObject(sql, new Object[]{id}, new DeptMappder());
		return dept;
	}

	@Override
	public List<Dept> findAll() {
		String sql = "select * from dept";
		List<Dept> list = template.query(sql, new DeptMappder());
		return list;
	}

}
