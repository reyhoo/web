package yaolei.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void beforeMethod(){
		System.out.println("----------执行前置通知的处理----------");
	}
	
	public void afterMethod(){
		System.out.println("----------执行最终通知的处理----------");
	}
	
	
	public Object aroundMethod(ProceedingJoinPoint pjp){
		try {
			System.out.println("-----环绕通知前期处理----");
			Object obj = pjp.proceed();//调用目标对象的业务方法
			System.out.println("-----环绕通知后期处理----");
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void afterReturnMethod(Object retVal){
		System.out.println("----------执行后置通知的处理----------"+retVal);
	}
	
	
	
}
