package com.mybatis2.exe.pojo;

public enum SexEnum {
	MALE(1,"ÄÐ"),FEMALE(0,"Å®");
	
	private int id;
	private String name;
	SexEnum(int id,String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static SexEnum getSexById(int id){
		for (SexEnum sexEnum : SexEnum.values()) {
			if(sexEnum.id == id){
				return sexEnum;
			}
		}
		return null;
	}
}
