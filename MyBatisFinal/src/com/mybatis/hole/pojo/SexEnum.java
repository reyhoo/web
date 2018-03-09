package com.mybatis.hole.pojo;

public enum SexEnum {

	FEMALE(0,"Ů"),MALE(1,"��");
	
	private int id;
	private String name;
	SexEnum(int id,String name){
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public static SexEnum getSexById(int id){
		for (SexEnum sex : SexEnum.values()) {
			if(sex.id == id){
				return sex;
			}
		}
		return null;
	}
}
