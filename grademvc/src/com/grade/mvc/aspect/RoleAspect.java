package com.grade.mvc.aspect;

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

	@Pointcut("execution(* com.grade.mvc.service.impl.RoleServiceImpl.*(..))")
	public void print(){}
	
	@Before("print()")
	public void before() {
		System.err.println("前置通知");
	}

	@After("print()")
	public void after() {
		System.err.println("后置通知");
	}

	@AfterReturning(pointcut="print()",returning="retVal")
	public void afterReturning(Object retVal) {
		System.err.println("后置通知afterReturning:"+retVal);
	}
	@AfterThrowing(pointcut="print()",throwing="e")
	public void afterThrowing(Exception e) {
		System.err.println("后置通知afterThrowing:"+e);
	}
	@Around("print()")
	public Object around(ProceedingJoinPoint pjp){
		try {
			Object obj = pjp.proceed();
			System.err.println("环绕通知正常返回");
			System.err.println("obj:"+obj);
			return obj;
		} catch (Throwable e) {
			System.err.println("环绕通知异常返回");
			e.printStackTrace();
			//如果遇到的切点是某个有事务的方法，这里有一定要抛出异常。否则即使发生异常，也会提交事务。
			throw new RuntimeException(e);
			
		}
//		return null;
	}
}
