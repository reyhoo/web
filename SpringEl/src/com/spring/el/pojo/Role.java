package com.spring.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("role")
public class Role {

	
	@Value("#{1}")
	private Long id;
	@Value("#{'role_name_1'}")
	private String roleName;
//	@Value("#{'note_1'}")
	private String note;
	
	
	
	public Role() {
		super();
	}




	public Role(Long id, String roleName, String note) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.note = note;
	}




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




	public String getNote() {
		return note;
	}




	public void setNote(String note) {
		this.note = note;
	}




	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note
				+ "]";
	}
	
	
}
