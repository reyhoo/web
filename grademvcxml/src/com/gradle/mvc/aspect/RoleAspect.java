package com.gradle.mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect

public class RoleAspect {

	@Pointcut("execution(* com.gradle.mvc.service.impl.RoleServiceImpl.*(..))")
	public void print(){
	}
	@Before("print()")
	public void before(){
		System.err.println("before...");
	}
	
	@After("print()")
	public void after(){
		System.err.println("after...");
	}
	
	@AfterThrowing(pointcut="print()",throwing="e")
	public void afterThrowing(Throwable e){
		System.err.println("afterThrowing...e:"+e.getMessage());
	}
	
	@AfterReturning(pointcut="print()",returning="retVal")
	public void afterReturning(Object retVal){
		System.err.println("afterReturning...retVal:"+retVal);
	}
	
	@Around("print()")
	public Object around(ProceedingJoinPoint pjp){
		Object obj = null;
		System.err.println("before around...");
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.err.println("after around...");
		return obj;
	}
	
}
