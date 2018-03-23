package com.mvc.annotation.aop;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleAspect {
	@Pointcut("execution(* com.mvc.annotation.service.impl.RoleServiceImpl.addRoles(..))")
	public void print() {
	}

	@Before("print()")
	public void before() {
		System.err.println("ǰ��֪ͨ");
	}

	@After("print()")
	public void after() {
		System.err.println("����֪ͨ");
	}

	@AfterReturning(pointcut="print()",returning="retVal")
	public void afterReturning(Object retVal) {
		System.err.println("����֪ͨafterReturning:"+retVal);
	}
	@AfterThrowing(pointcut="print()",throwing="e")
	public void afterThrowing(Exception e) {
		System.err.println("����֪ͨafterThrowing:"+e);
	}
	@Around("print()")
	public Object around(ProceedingJoinPoint pjp){
		try {
			Object obj = pjp.proceed();
			System.err.println("����֪ͨ��������");
			System.err.println("obj:"+obj);
			return obj;
		} catch (Throwable e) {
			System.err.println("����֪ͨ�쳣����");
			e.printStackTrace();
			
			//����������е���ĳ��������ķ�����������һ��Ҫ�׳��쳣������ʹ�����쳣��Ҳ���ύ����
			throw new RuntimeException(e);
			
		}
//		return null;
	}

}
