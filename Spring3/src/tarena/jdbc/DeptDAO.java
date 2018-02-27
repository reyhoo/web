package tarena.jdbc;

import java.util.List;

public interface DeptDAO {
	public void save(Dept dept);
	public void delete(int id);
	public void update(Dept dept);
	public Dept findById(int id);
	public List<Dept> findAll();
}
