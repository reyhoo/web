package com.mvcdev.exe.pojo;

public class Role {

	private Long id;
	private String roleName;
	private String note;
	
	private PageParams pageParams;
	
	private Boolean isCurr;
	
	public Long getId() {
		return id;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note
				+ ", pageParams=" + pageParams + "]";
	}
	public void setPageParams(PageParams pageParams) {
		this.pageParams = pageParams;
	}
	public PageParams getPageParams() {
		return pageParams;
	}
	
	public Boolean getIsCurr() {
		return isCurr;
	}
	public void setIsCurr(Boolean isCurr) {
		this.isCurr = isCurr;
	}
	
}
