package aop.annotation.aspect;

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
public class TimeHander {
	@Pointcut("bean (*Service)")
	public void myPointCut(){};
	
	@AfterThrowing(pointcut="bean (*Service)",throwing="ex")
	public void executeException(Exception ex){
		System.out.println("-------处理异常--------"+ex);
	}
	
	@AfterReturning(pointcut="bean (*Service)",returning="retVal")
	public void myReturning(Object retVal){
		System.out.println("---后置通知---"+retVal);
	}
	
	
	@Before("myPointCut()")
	public void myBefore(){
		System.out.println("--------执行before处理---------");
	}
	
	
	@Around("myPointCut()")
	public Object handerTime(ProceedingJoinPoint pjp){
		try {
			//开始计时
			//获取目标对象的类名
			StopWatch watch = new StopWatch(pjp.getTarget().getClass().getName());
			watch.start(pjp.getSignature().getName());//获取方法名
			Object obj = pjp.proceed();//执行目标对象的业务方法
			//停止计时
			watch.stop();
			System.out.println(watch.prettyPrint());
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
