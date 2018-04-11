package com.mvc.exe.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.RequestParam;

public class Role {

	private Long id;
	@NotNull(message="角色名称不能为空")
	@Size(min=1,max=60,message="角色名称长度1到60")
	private String roleName;
	@NotNull
	@Size(min=1,max=100)
	private String note;
	private Long userId;
	private String pic;
	
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note + ", userId=" + userId + ", pic=" + pic
				+ "]";
	}
	
	
	
}
