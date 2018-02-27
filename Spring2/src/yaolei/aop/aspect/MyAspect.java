package yaolei.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void beforeMethod(){
		System.out.println("----------ִ��ǰ��֪ͨ�Ĵ���----------");
	}
	
	public void afterMethod(){
		System.out.println("----------ִ������֪ͨ�Ĵ���----------");
	}
	
	
	public Object aroundMethod(ProceedingJoinPoint pjp){
		try {
			System.out.println("-----����֪ͨǰ�ڴ���----");
			Object obj = pjp.proceed();//����Ŀ������ҵ�񷽷�
			System.out.println("-----����֪ͨ���ڴ���----");
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void afterReturnMethod(Object retVal){
		System.out.println("----------ִ�к���֪ͨ�Ĵ���----------"+retVal);
	}
	
	
	
}
