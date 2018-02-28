package com.mybatis2.pojo;



public class Role {

	private Long id;
	private String roleName;
	private String note;
	private Boolean isStu;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	
	
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	
	public void setIsStu(Boolean isStu) {
		this.isStu = isStu;
	}
	public Boolean getIsStu() {
		return isStu;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note
				+ ", isStu=" + isStu + "]";
	}
	
	
	
}
