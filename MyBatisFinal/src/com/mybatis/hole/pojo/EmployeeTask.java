package com.mybatis.hole.pojo;

public class EmployeeTask {

	private Long id;
	private Long empId;
	private Task task;
	private String taskName;
	private String note;
	public Long getId() {
		return id;
	}
	public Long getEmpId() {
		return empId;
	}
	public Task getTask() {
		return task;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
