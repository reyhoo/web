package com.myec.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private Long id;
	@NotNull(message="�û�������Ϊ��")
	@Pattern(regexp="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",
			message="�û�����ʽ����")
	private String username;
	@NotNull(message="���벻��Ϊ��")
	@Pattern(regexp= "^\\*{6,20}$",message="�����ʽ����")
//	@Pattern(regexp= "^[a-zA-Z0-9]{6,20}$",message="�����ʽ����")
	private String password;
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
