package com.gradle.mvc.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Role {

	private Long id;
	@Size(min=1,max=60)
	private String roleName;
	@Size(min=1,max=512)
	private String note;
	
	
	
	public Long getId() {
		return id;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getNote() {
		return note;
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

	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note+
			"]";
	}
	
	
}
