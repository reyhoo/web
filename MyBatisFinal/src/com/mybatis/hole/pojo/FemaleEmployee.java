package com.mybatis.hole.pojo;

public class FemaleEmployee extends Employee{

	private FemaleHealthForm femaleHealthForm;
	
	public FemaleHealthForm getFemaleHealthForm() {
		return femaleHealthForm;
	}
	public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
		this.femaleHealthForm = femaleHealthForm;
	}
}
