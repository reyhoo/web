package yaolei.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeHandler {
	
	@Pointcut("execution (* yaolei.aop.annotation.service.*.*(..))")
	public void myPointCut(){}
	
	
	@Before("myPointCut()")
	public void myBefore(){
		System.out.println("---myBefore---");
	}
	@After(value = "myPointCut()")
	public void myAfter(){
		System.out.println("---myAfter---");
	}
	@AfterReturning(pointcut="bean (*Service)",returning="retVal")
	public void myReturning(Object retVal){
		System.out.println("---myReturning---"+retVal);
	}
	@AfterThrowing(pointcut="bean (*Service)",throwing="e")
	public void executeException(Exception e){
		System.out.println("---executeException---"+e);
	}
	
	@Around("myPointCut()")
	public Object handerTime(ProceedingJoinPoint pjp){
		try{
			//��ʼ��ʱ
			//��ȡĿ����������
			StopWatch watch = new StopWatch(pjp.getTarget().getClass().getName());
			watch.start(pjp.getSignature().getName());//��ȡ������
			Object obj = pjp.proceed();//ִ��Ŀ������ҵ�񷽷�
			//ֹͣ��ʱ
			watch.stop();
			System.out.println(watch.prettyPrint());
			return obj;
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
		
	}
}
