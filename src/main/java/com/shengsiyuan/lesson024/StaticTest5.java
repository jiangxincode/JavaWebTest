package com.shengsiyuan.lesson024;

public class StaticTest5 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		W w = new W();
		w.change();
	}
}

class W {
	static int a = 10;

	public static void change() {
		a++;
	}
}
