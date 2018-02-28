package com.mybatis2.pojo;

public class User {
	
	private Long id;
	private String userName;
	private SexEnum sex;
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", sex=" + sex
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public SexEnum getSex() {
		return sex;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	
	

}
