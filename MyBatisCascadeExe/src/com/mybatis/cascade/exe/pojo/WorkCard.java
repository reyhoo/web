package com.mybatis.cascade.exe.pojo;

public class WorkCard {

	
	private Long id;
	@Override
	public String toString() {
		return "WorkCard [id=" + id + ", empId=" + empId + ", realName="
				+ realName + ", department=" + department + ", mobile="
				+ mobile + ", position=" + position + ", note=" + note + "]";
	}
	private Long empId;
	private String realName;
	private String department;
	private String mobile;
	private String position;
	private String note;
	public Long getId() {
		return id;
	}
	public Long getEmpId() {
		return empId;
	}
	public String getRealName() {
		return realName;
	}
	public String getDepartment() {
		return department;
	}
	public String getMobile() {
		return mobile;
	}
	public String getPosition() {
		return position;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
