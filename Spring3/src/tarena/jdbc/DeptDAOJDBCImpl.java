package tarena.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeptDAOJDBCImpl implements DeptDAO{
	private JdbcTemplate template;//增删改查工具类
	//接收容器注入的dataSource数据源对象
	public void setDataSource(DataSource source){
		template = new JdbcTemplate(source);
	}
	public void delete(int id) {
		String sql = "delete from dept where id=?";
		Object[] params = new Object[]{id};
		template.update(sql,params);
	}

	public Dept findById(int id) {
		String sql = "select * from dept where id=?";
		Dept dept = (Dept)template.queryForObject(sql, new Object[]{id},new DeptMappder());
		return dept;
	}

	public void save(Dept dept) {
		String sql = "insert into dept(dname,loc) values (?,?)";
		Object[] params = new Object[]{dept.getDname(),dept.getLoc()};
		template.update(sql,params);
	}

	public void update(Dept dept) {
		String sql = "update dept set dname=?,loc=? where id=?";
		Object[] params = new Object[]{dept.getDname(),dept.getLoc(),dept.getId()};
		template.update(sql,params);
	}

	public List<Dept> findAll() {
		String sql = "select * from dept";
		List<Dept> list = template.query(sql, new DeptMappder());
		return list;
	}

}
