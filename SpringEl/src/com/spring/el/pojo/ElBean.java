package com.spring.el.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elBean")
public class ElBean {

	@Value("#{role}")
//	@Autowired
	private Role role;
	@Value("#{role.id}")
	private Long id;
	@Value("#{role.getNote()?.toString()}")//如果getNote()方法返回是null，用？判断去执行
	private String note;
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	@Override
	public String toString() {
		return "ElBean [role=" + role + ", id=" + id + ", note=" + note + "]";
	}
	
}
