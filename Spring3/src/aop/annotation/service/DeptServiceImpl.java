package aop.annotation.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("deptService")
@Scope("prototype")
public class DeptServiceImpl implements DeptService {

	public void delete() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = null;
		s.length();
		System.out.println("ɾ�����Ų���");
	}

	public void save() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��Ӳ��Ų���");

	}

}
