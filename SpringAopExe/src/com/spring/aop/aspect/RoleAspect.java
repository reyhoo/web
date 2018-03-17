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

	@DeclareParents(defaultImpl=RoleVerifierImpl.class,value="com.spring.aop.service.impl.RoleServiceImpl+")
	public RoleVerifier roleVerifier;
	@Pointcut("execution(* com.spring.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void print() {
	}

	@Before("execution(* com.spring.aop.service.impl.RoleServiceImpl.printRole(..)) && args(role)")
	public void before(Role role) {
		System.out.println("before ......"+role);
	}

	@After("print()")
	public void after() {
		System.out.println("after ......");
	}
	@Around("print()")
	public void around(ProceedingJoinPoint pjp){
		System.out.println("around before ......");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("around after ......");
	}

	@AfterThrowing(pointcut = "print()")
	public void afterThrowing() {
		System.out.println("afterThrowing ......");
	}

	@AfterReturning(pointcut = "print()")
	public void afterReturning() {
		System.out.println("afterReturning ......");
	}
}
