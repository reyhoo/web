package com.annotation.redis.pojo;

public class Role implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 551224583141983994L;
	private Long id;
	private String roleName;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
