package com.spring.ass.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleService;
@Component
public class RoleController {
//	�����ֶ��ʵ����ʱ,����Ҫ��ʵ����(RoleServiceImpl3)�ϼ�@Primaryע��,������ʵ���඼���˸�ע���Ҫʹ��@Qualifier��id����
	@Autowired
	@Qualifier("roleServiceImpl3")
	private RoleService roleService=null;
	
	public void printRole(Role role){
		roleService.printRoleInfo(role);
	}
}
