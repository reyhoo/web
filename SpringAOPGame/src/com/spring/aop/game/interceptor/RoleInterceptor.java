package com.spring.aop.game.interceptor;

public class RoleInterceptor implements Interceptor {

	@Override
	public void before(Object obj) {
		System.out.println("׼����ӡ��ɫ��Ϣ");
	}

	@Override
	public void after(Object obj) {
		System.out.println("�Ѿ���ɽ�ɫ��Ϣ�Ĵ�ӡ����");
	}

	@Override
	public void afterRetuning(Object obj) {
		System.out.println("�ո���ɴ�ӡ���ܣ�һ��������");
	}

	@Override
	public void afterThrowing(Object obj) {
		System.out.println("��ӡ����ִ���쳣�ˣ��鿴һ�½�ɫ����Ϊ������");
	}

}
