package edu.jiangxin.time;

public class TestObject {
	/**
	 * 一个用来被测试的方法，进行了一个比较耗时的循环
	 */
	public static void testMethod() {
		for (int i = 0; i < 100000000; i++) {
			continue;
		}
	}

	/**
	 * 一个简单的测试方法执行时间的方法
	 */
	public void testTime() {
		long begin = System.currentTimeMillis(); // 测试起始时间
		testMethod(); // 测试方法
		long end = System.currentTimeMillis(); // 测试结束时间
		System.out.println("[use time(ms)]:" + (end - begin)); // 打印使用时间
	}

	public static void main(String[] args) {
		TestObject test = new TestObject();
		test.testTime();
	}
}
