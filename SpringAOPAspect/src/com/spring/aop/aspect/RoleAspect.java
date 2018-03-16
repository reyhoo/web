package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.aop.pojo.Role;
import com.spring.aop.verifier.RoleVerifier;
import com.spring.aop.verifier.impl.RoleVerifierImpl;


@Aspect
public class RoleAspect {
	
	
	@DeclareParents(value="com.spring.aop.service.RoleServiceImpl+",defaultImpl=RoleVerifierImpl.class)
	public RoleVerifier roleVerifier;
	
	@Pointcut("execution(* com.spring.aop.service.RoleServiceImpl.printRole(..))")
	public void print(){
		
	}
	
	
//	@Before("execution(* com.spring.aop.service.RoleServiceImpl.printRole(..)) && args(role,sort)")
//	public void before(Role role,int sort){
//		System.out.println("before........");
//	}
	@Before("print()")
	public void before(){
	System.out.println("before........");
}
	@After(value="print()")
	public void after(){
		System.out.println("after.........");
	}
	@AfterReturning(pointcut="print()")
	public void afterReturning(){
		System.out.println("afterReturning..........");
	}
	@AfterThrowing(pointcut="print()")
	public void afterThrowing(){
		System.out.println("afterThrowing............");
	}
	@Around("print()")
	public void around(ProceedingJoinPoint jp){
		System.out.println("around before....");
		
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("around after....");
	}
}
