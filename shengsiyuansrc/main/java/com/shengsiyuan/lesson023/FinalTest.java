package com.shengsiyuan.lesson023;

public class FinalTest {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		F f = new F();
	}
}

// final class E // 该类不能被继承
class E {

}

class F extends E {

}
