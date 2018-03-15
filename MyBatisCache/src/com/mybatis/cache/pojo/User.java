package com.mybatis.cache.pojo;

public class User

implements java.io.Serializable

{

	
	private Long id;
	private String userName;
	private String realName;
	private SexEnum sex;
	private String mobile;
	private String email;
	private String note;
	
	
	
	
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




	public String getRealName() {
		return realName;
	}




	public void setRealName(String realName) {
		this.realName = realName;
	}




	public SexEnum getSex() {
		return sex;
	}




	public void setSex(SexEnum sex) {
		this.sex = sex;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getNote() {
		return note;
	}




	public void setNote(String note) {
		this.note = note;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", realName="
				+ realName + ", sex=" + sex + ", mobile=" + mobile + ", email="
				+ email + ", note=" + note + "]";
	}
	
	
	
}
