package com.mybatis2.exe.pojo;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;



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
