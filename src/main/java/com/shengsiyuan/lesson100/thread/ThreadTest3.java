package com.shengsiyuan.lesson100.thread;

public class ThreadTest3 {
	public static void main(String[] args) {
		Runnable r = new HelloThread();

		Thread t1 = new Thread(r);

		// r = new HelloThread();

		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class HelloThread implements Runnable {
	//int i; //两个线程访问同一个对象

	@Override
	public void run() {
		int i = 0;

		while (true) {
			//System.out.println("number: " + this.i++);
			System.out.println("number: " + i++);

			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//if (50 == this.i) {
			if (50 == i) {
				break;
			}
		}
	}
}
