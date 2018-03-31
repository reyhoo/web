package com.annotation.redis.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RoleAspect {

	@Around("execution(* com.annotation.redis.service.impl.RoleServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp){
		System.err.println("RoleAspect....around...start");
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}
