package aop.service;

public class DeptServiceImpl implements DeptService {

	public void delete() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
