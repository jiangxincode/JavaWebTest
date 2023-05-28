package com.shengsiyuan.lesson023;

public class StaticTest3 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		M m = new N();

		m.output(); // 为什么输出M可以查看官方文档，google 搜索java static override
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
