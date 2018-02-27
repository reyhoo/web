package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TimeHander {
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
