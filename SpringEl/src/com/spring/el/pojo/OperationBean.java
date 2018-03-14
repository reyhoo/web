package com.spring.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class OperationBean {

	@Value("#{role.id+1}")
	private int num;
	@Value("#{role.roleName+role.note}")
	private String str;
	
	@Value("#{role.id == 2}")
	private boolean equalNum;
	
	@Value("#{role.roleName eq 'role_name_1'}")
	private boolean equalString;
	
	@Value("#{role.id > 2}")
	private boolean greater;
	@Value("#{role.id < 2}")
	private boolean less;
	@Value("#{role.id > 1?5:1}")
	private int max;
	@Value("#{role.note?:'hello'}")
	private String defaultString;
	public int getNum() {
		return num;
	}
	
	public String getStr() {
		return str;
	}
	
	public boolean isEqualNum() {
		return equalNum;
	}
	
	public boolean isEqualString() {
		return equalString;
	}
	
	public boolean isGreater() {
		return greater;
	}
	
	public boolean isLess() {
		return less;
	}
	
	public int getMax() {
		return max;
	}
	public String getDefaultString() {
		return defaultString;
	}
}


