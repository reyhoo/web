package com.mybatis.cache.pojo;



public enum SexEnum {
	MALE(1,"��"),FEMALE(0,"Ů");
	
	SexEnum(int id,String name){
		this.id = id;
		this.name = name;
	}
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
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
