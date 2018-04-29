package com.mvc.exe.pojo;

public enum Sex {
	FEMALE(0,"Å®"),MALE(1,"ÄÐ");
	
	
	private int id;
	private String name;
	
	Sex(int id ,String name){
		this.id  = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public static Sex getSexById(int id) {
		for (Sex sex : Sex.values()) {
			if(sex.id == id) {
				return sex;
			}
		}
		return null;
	}
}
