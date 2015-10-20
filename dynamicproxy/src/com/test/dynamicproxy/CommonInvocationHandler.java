package com.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHandler implements InvocationHandler {

	// ��ִ̬�ж�����Ҫ�ص��Ķ���
	private Object target;

	// ֧�ֹ��췽��ע��
	public CommonInvocationHandler() {

	}

	// ֧�ֹ��췽��ע��
	public CommonInvocationHandler(Object target) {
		setTarget(target);
	}

	/**
	 * 
	 * ����setter����ע��
	 * 
	 * @param target
	 * 
	 */
	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * 
	 * ����proxy��ָ���ķ���method������������б�args
	 * 
	 * @param proxy
	 *            ����������ͣ����綨���Ӧmethod�Ĵ���ӿ�
	 * 
	 * @param method
	 *            ������ķ���
	 * 
	 * @param args
	 *            ���ñ��������Ĳ���
	 * 
	 * @return
	 * 
	 * @throws java.lang.Throwable
	 * 
	 */

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(target, args);
	}

}
