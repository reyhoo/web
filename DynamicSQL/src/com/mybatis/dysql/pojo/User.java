package com.mybatis.dysql.pojo;


public class User {

	private Long id;
	private String userName;
	private String realName;
	private String mobile;
	private String email;
	private String note;
	private SexEnum sex;
	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getRealName() {
		return realName;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getNote() {
		return note;
	}
	public SexEnum getSex() {
		return sex;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", realName="
				+ realName + ", mobile=" + mobile + ", email=" + email
				+ ", note=" + note + ", sex=" + sex
				+ "]";
	}
	
	
	
}
