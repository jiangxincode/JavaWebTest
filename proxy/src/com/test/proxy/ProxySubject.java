package com.test.proxy;

//�����ɫ

public class ProxySubject extends Subject {
	private RealSubject realSubject; // ����ʵ��ɫ��Ϊ�����ɫ������

	public ProxySubject() {
	}

	public void request() // �÷�����װ����ʵ�����request����
	{
		preRequest();

		if (realSubject == null) {
			realSubject = new RealSubject();
		}

		realSubject.request(); // �˴�ִ����ʵ�����request����

		postRequest();
	}

	private void preRequest() {
		System.out.println("pre request");
	}

	private void postRequest() {
		System.out.println("post request");
	}

}
