package com.yuqiaotech.helloj2ee.java.thread;

/**
 * 多线程编程中线程同步：Synchronized关键字
 * 
 */
public class ThreadSynchronizedDemo {
	public static void main(String[] args) {
		final SynDemo synDemo = new SynDemo();
		Thread thread1 = new Thread() {
			public void run() {
				super.run();
				synDemo.synMethord1();
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				super.run();
				synDemo.synMethord2();
			}
		};
		thread1.start();
		thread2.start();
		// isInterrupted()方法是判断该线程是否受到中断信息。
		System.out.println(thread1.isInterrupted());
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				System.out.println("main");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class SynDemo {
	public synchronized void synMethord1() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100); // 让当前的线程在指定的时间内处于休眠状态。
				System.out.println("synMethord1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 大家不妨运行一下和不加synchronized运行的结果做比较
	// 对于SynDemo对象，只有synMethord1运行了，而synMethord2却没有运行。这是应为在方法级别的synchronized声明将lock这个类对象的当前实例。
	// 所以在synMethord1运行结束unlock之前，当前实例是无法运行synMethord2的
	// 当然可以把同步方法转换为同步块 例：
	// voidsynMethod2(){
	// synchronized(this){
	// [代码];
	// }
	// };
	public synchronized void synMethord2() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
				System.out.println("synMethord2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
