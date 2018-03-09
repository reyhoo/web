package com.mybatis.hole.pojo;

import java.util.List;

public class Employee {

	
	private Long id;
	private String realName;
	private SexEnum sex;
	private String birthday;
	private String mobile;
	private String email;
	private String position;
	private String note;
	private WorkCard workCard;
	private List<EmployeeTask> employeeTaskList;
	public Long getId() {
		return id;
	}
	public String getRealName() {
		return realName;
	}
	public SexEnum getSex() {
		return sex;
	}
	public String getBirthday() {
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
	public WorkCard getWorkCard() {
		return workCard;
	}
	public List<EmployeeTask> getEmployeeTaskList() {
		return employeeTaskList;
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
	public void setBirthday(String birthday) {
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
	public void setWorkCard(WorkCard workCard) {
		this.workCard = workCard;
	}
	public void setEmployeeTaskList(List<EmployeeTask> employeeTaskList) {
		this.employeeTaskList = employeeTaskList;
	}
	
	
}
