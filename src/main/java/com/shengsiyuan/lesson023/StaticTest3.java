package com.shengsiyuan.lesson023;

public class StaticTest3 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		M m = new N();

		m.output(); // Ϊʲô���M���Բ鿴�ٷ��ĵ���google ����java static override
	}
}

class M {
	public static void output() {
		System.out.println("M");
	}
}

class N extends M {
	public static void output() {
		System.out.println("N");
	}
}
