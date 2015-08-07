package com.shengsiyuan.lesson065.proxy;

public class Client {
	public static void main(String[] args) {
		Subject subject = new ProxySubject();

		subject.request();
	}
}
