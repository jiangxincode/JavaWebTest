package com.shengsiyuan.lesson027;

import com.shengsiyuan.lesson027.C;

public class D extends C {
	public void output() {
		System.out.println(year);
	}

	public static void main(String[] args) {
		D d = new D();
		d.output();
	}
}
