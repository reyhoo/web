package com.spring.aop.game;

import com.spring.aop.game.interceptor.Interceptor;
import com.spring.aop.game.interceptor.RoleInterceptor;
import com.spring.aop.game.pojo.Role;
import com.spring.aop.game.service.RoleService;
import com.spring.aop.game.service.RoleServiceImpl;
import com.spring.aop.game.util.ProxyBeanFactory;

public class MainTest {

	
	public static void main(String[] args) {
		RoleService roleService = new RoleServiceImpl();
		Interceptor interceptor = new RoleInterceptor();
		RoleService serviceProxy = ProxyBeanFactory.getBean(roleService, interceptor);
		Role role = new Role(1l,"role_name_1","note_1");
		serviceProxy.printRole(role);
		serviceProxy.printRole(null);
	}
}
