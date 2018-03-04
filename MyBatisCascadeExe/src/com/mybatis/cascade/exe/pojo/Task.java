package com.mybatis.cascade.exe.pojo;

public class Task {
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", context=" + context
				+ ", note=" + note + "]";
	}
	private Long id;
	private String title;
	private String context;
	private String note;
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContext() {
		return context;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	

}
