package com.spring.aop.multi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class Aspect2 {

	@Pointcut("execution(* com.spring.aop.multi.bean.impl.MultiBeanImpl.testMulti(..))")
	public void print() {
	}

	@Before("print()")
	public void before() {
		System.out.println("before 2 ......");
	}

	@After("print()")
	public void after() {
		System.out.println("after 2 ......");
	}

	@AfterThrowing(pointcut = "print()")
	public void afterThrowing() {
		System.out.println("afterThrowing 2 ......");
	}

	@AfterReturning(pointcut = "print()")
	public void afterReturning() {
		System.out.println("afterReturning 2 ......");
	}
	
	@Around("print()")
	public void around(ProceedingJoinPoint pjp){
		System.out.println("before around 2 ......");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("after around 2 ......");
	}
}
