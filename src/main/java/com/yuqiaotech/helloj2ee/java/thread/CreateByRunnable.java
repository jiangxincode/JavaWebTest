package com.yuqiaotech.helloj2ee.java.thread;

/**
 * 实现java.lang.Runnable接口并实现它的run()方法来创建多线程
 * 
 */
public class CreateByRunnable {
	public static void main(String[] args) {
		Runnable myr = new MyRunnable("myRunnable");
		Thread t = new Thread(myr);
		// System.out.println(t.isAlive());
		t.start();
		// 判断当前线程时都处于存活状态，即true为存活，false为死亡
		// System.out.println(t.isAlive());
		System.out.println("------------------");
		System.out.println(t.toString()); // 返回该线程的字符串表示形式，包括线程名称、优先级和线程组
	}
}

class MyRunnable implements Runnable {
	String name;

	public MyRunnable() {
	}

	public MyRunnable(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + ":" + i);
		}
	}

}
