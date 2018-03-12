package com.spring.ass.annotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Role {

	@Value("1")
	private Long id;
	@Value("role_name_1")
	private String roleName;
	@Value("note_1")
	private String note;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getNote() {
		return note;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note
				+ "]";
	}
	
}
