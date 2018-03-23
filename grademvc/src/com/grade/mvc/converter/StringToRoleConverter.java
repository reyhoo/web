package com.grade.mvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.grade.mvc.pojo.Role;

public class StringToRoleConverter implements Converter<String, Role>{

	@Override
	public Role convert(String str) {
		if(StringUtils.isEmpty(str)){
			return null;
		}
		if(!str.contains("-")){
			return null;
		}
		String[] arr =str.split("-");
		if(arr.length!=3){
			return null;
		}
		Role role = new Role();
		role.setId(Long.parseLong(arr[0]));
		role.setRoleName(arr[1]);
		role.setNote(arr[2]);
		return role;
	}

	
}
