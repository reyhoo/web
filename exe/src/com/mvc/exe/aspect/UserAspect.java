package com.mvc.exe.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

	@Pointcut("execution (* com.mvc.exe.service.impl.UserServiceImpl.*(..))")
	public void print() {}
	@Before("print()")
	public void before() {
		System.err.println("before...");
	}
	@Around("print()")
	public Object pjp(ProceedingJoinPoint pjp) {
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
