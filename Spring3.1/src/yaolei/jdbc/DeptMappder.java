package yaolei.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptMappder implements RowMapper {

	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Dept dept = new Dept();
		int id = rs.getInt("id");
		dept.setId(id);
		String dname = rs.getString("dname");
		dept.setDname(dname);
		String loc = rs.getString("loc");
		dept.setLoc(loc);
		return dept;
	}

}
