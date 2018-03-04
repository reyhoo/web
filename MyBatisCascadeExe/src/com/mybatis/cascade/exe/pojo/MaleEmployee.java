package com.mybatis.cascade.exe.pojo;

public class MaleEmployee extends Employee {

	private MaleHealthForm maleHealthForm;

	public MaleHealthForm getMaleHealthForm() {
		return maleHealthForm;
	}

	public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
		this.maleHealthForm = maleHealthForm;
	}
	
	
}
