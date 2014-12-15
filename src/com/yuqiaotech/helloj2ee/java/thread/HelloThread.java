package com.yuqiaotech.helloj2ee.java.thread;

import java.util.Random;

public class HelloThread {

	public static void main(String[] args) {
		Runnable r = new Threadx();
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
		
		//Runnable r2 = new Threadx();
		Runnable r2 = r;
		Thread t2 = new Thread(r2);
		t2.start();
		
		Thread t3 = new Thread(new Runnable(){
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t3:my name is "+Thread.currentThread().getName());
				}
			}
		});
		t3.start();
		
		System.out.println("HelloThread.main()");
	}
	static class Threadx implements Runnable{
		private int cnt;
		public void run() {
			while(true){
				try {
					int t = new Random().nextInt(500)+1000;
					Thread.sleep(t);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("my name is "+Thread.currentThread().getName()+" cnt="+cnt++);
			}
		}
		
	}
}
