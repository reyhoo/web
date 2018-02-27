package yaolei.jdbc;

public class Dept {
	private int id;
	private String dname;
	private String loc;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}
