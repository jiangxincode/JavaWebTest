package com.yuqiaotech.helloj2ee.java.thread;

/**
 * 扩展java.lang.Thread类并重写它的run()方法来创建多线程
 * 
 */
public class CreateByThread extends Thread {
	@Override
	// 在这里Thread.currentThread().getName()是获取当前正在运行的线程的名称
	// 还有一种就是super.getName()方法也是返回线程的名称，基本形式为"Thread-号码"。
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			// yield(); 调用这个方法会使当前的正在执行的线程对象退出运行状态。
			try {
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println(super.getName()+":"+i);
		}
	}

	public static void main(String[] args) {
		Thread t = new CreateByThread();
		Thread t1 = new CreateByThread();
		// t.setPriority(Thread.MIN_PRIORITY);//这里主要是设置线程的优先级。
		// t1.setPriority(Thread.MAX_PRIORITY);
		t.start();
		t1.start();
	}
}

/*
 * 注意：一个线程被创建后，总是处于一下几种状态之一。Thread类的getState()方法获得当前线程对象的状态。 1). 新建态：
 * 使用new运算符创建一个线程对象后，该线程仅仅是一个空的对象，系统没有为它分配资源，该线程处于新建态。 2).
 * 就绪态和运行态：处于新建态的线程启动后，进入就绪态，再有系统调度执行而成为运行态。由于线程调度有系统控制和管理，程序无法控制。
 * 所以从程序设计角度看，线程启动后即进入运行状态(Runnable)程序中就不需要区分就绪后运行态。
 * 进入运行态的线程对象，系统执行线程对象的run()方法。
 * 3).阻塞态和等待态：一个运行态的线程因某种原因不能继续运行，即进入阻塞态(Blocked)或等待态。处于阻塞态或等待态的线程不能执行，
 * 即使处理器空闲也不能执行。只用当引起阻塞的原因被消除，或等待的条件满足时，线程进入运行态，重新进入线程对列排队等待运行，再次运行时将暂停处继续运行。
 * 4).终止态：线程对象停止运行位被撤销时时终止状态(Terminated)。导致线程终止有两种情况：运行结果或强行终止。
 * 当线程对象的run()方法执行结束后，该线程对象进入终止态，等待系统撤销对象所占用的资源；当进程因故停止运行时，该进程中的所有线程将被强行终止。
 */