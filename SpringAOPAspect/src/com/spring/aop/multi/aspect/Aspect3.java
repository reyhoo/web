package com.spring.aop.multi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Aspect
//@Order(3)
public class Aspect3 implements Ordered{

	@Pointcut("execution(* com.spring.aop.multi.bean.impl.MultiBeanImpl.testMulti(..))")
	public void print() {
	}

	@Before("print()")
	public void before() {
		System.out.println("before 3 ......");
	}

	@After("print()")
	public void after() {
		System.out.println("after 3 ......");
	}

	@AfterThrowing(pointcut = "print()")
	public void afterThrowing() {
		System.out.println("afterThrowing 3 ......");
	}

	@AfterReturning(pointcut = "print()")
	public void afterReturning() {
		System.out.println("afterReturning 3 ......");
	}
	
	@Around("print()")
	public void around(ProceedingJoinPoint pjp){
		System.out.println("before around 3 ......");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("after around 3 ......");
	}

	@Override
	public int getOrder() {
		return 3;
	}
}
