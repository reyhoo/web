package com.spring.aop.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.spring.aop.pojo.Role;
import com.spring.aop.verifier.RoleVerifier;

public class RoleXmlAspect {

	
	public RoleVerifier roleVerifier;
	public void before(Role role) {
		System.out.println("before........");
	}

	public void after() {
		System.out.println("after........");
	}

	public void afterThrowing() {
		System.out.println("afterThrowing........");
	}

	public void afterReturning() {
		System.out.println("afterReturning........");
	}
	
	public void around(ProceedingJoinPoint pjp){
		System.out.println("around before........");
		try {
			pjp.proceed();
		} catch (Throwable e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("around after........");
	}

}
