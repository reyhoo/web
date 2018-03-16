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
@Order(1)
public class Aspect1 {

	@Pointcut("execution(* com.spring.aop.multi.bean.impl.MultiBeanImpl.testMulti(..))")
	public void print() {
	}

	@Before("print()")
	public void before() {
		System.out.println("before 1 ......");
	}

	@After("print()")
	public void after() {
		System.out.println("after 1 ......");
	}

	@AfterThrowing(pointcut = "print()")
	public void afterThrowing() {
		System.out.println("afterThrowing 1 ......");
	}

	@AfterReturning(pointcut = "print()")
	public void afterReturning() {
		System.out.println("afterReturning 1 ......");
	}
	@Around("print()")
	public void around(ProceedingJoinPoint pjp){
		System.out.println("before around 1 ......");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("after around 1 ......");
	}
}
