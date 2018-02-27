package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TimeHander {
	public Object handerTime(ProceedingJoinPoint pjp){
		try {
			//��ʼ��ʱ
			//��ȡĿ����������
			StopWatch watch = new StopWatch(pjp.getTarget().getClass().getName());
			watch.start(pjp.getSignature().getName());//��ȡ������
			Object obj = pjp.proceed();//ִ��Ŀ������ҵ�񷽷�
			//ֹͣ��ʱ
			watch.stop();
			System.out.println(watch.prettyPrint());
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
