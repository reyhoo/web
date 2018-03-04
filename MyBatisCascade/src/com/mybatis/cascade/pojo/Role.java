package com.mybatis.cascade.pojo;

import java.util.List;

public class Role {

	private Long id;
	private String roleName;
	private String note;
	private List<User>userList;
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note
				+ ", userList=" + userList + "]";
	}
	public Long getId() {
		return id;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getNote() {
		return note;
	}
	public List<User> getUserList() {
		return userList;
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
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
