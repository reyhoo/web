package com.mybatis.cascade.exe.pojo;

import java.util.Date;
import java.util.List;

public class Employee {

	private Long id;
	private String realName;
	private SexEnum sex;
	private Date birthday;
	private String mobile;
	private String email;
	private String position;
	private String note;
	private List<EmployeeTask> employeeTaskList;
	private WorkCard workCard;
	public Long getId() {
		return id;
	}
	public String getRealName() {
		return realName;
	}
	public SexEnum getSex() {
		return sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getPosition() {
		return position;
	}
	public String getNote() {
		return note;
	}
	public List<EmployeeTask> getEmployeeTaskList() {
		return employeeTaskList;
	}
	public WorkCard getWorkCard() {
		return workCard;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setEmployeeTaskList(List<EmployeeTask> employeeTaskList) {
		this.employeeTaskList = employeeTaskList;
	}
	public void setWorkCard(WorkCard workCard) {
		this.workCard = workCard;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", realName=" + realName + ", sex=" + sex.getName()
				+ ", birthday=" + birthday + ", mobile=" + mobile + ", email="
				+ email + ", position=" + position + ", note=" + note
				+ ", employeeTaskList=" + employeeTaskList + ", workCard="
				+ workCard + "]";
	}
	
}
