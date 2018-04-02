package com.jstl.tag.pojo;

import java.util.Date;

public class User {

	private Long id;
	private String userName;
	private int sex;
	private int posi;
	private Date birthday;
	private String note;
	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public int getSex() {
		return sex;
	}
	public int getPosi() {
		return posi;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setPosi(int posi) {
		this.posi = posi;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
