package com.mybatis2.pojo;

public enum SexEnum {

	MALE(1,"��"),FEMALE(0,"Ů");
	private int id;
	private String name;
	SexEnum(int id,String name){
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static SexEnum getSexById(int id){
		for (SexEnum sex : SexEnum.values()) {
			if(sex.getId() == id){
				return sex;
			}
		}
		return null;
	}
}
