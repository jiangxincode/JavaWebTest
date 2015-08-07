package com.yuqiaotech.helloj2ee.java.thread.waitnotify1;

import java.util.List;

/**
 * 使用wait/notify进行线程间通信例子 生产线程向队列存入一个肉串对象,消费线程立即取出 改编自www.NetJava.cn的一个例子。
 */
public class WaitNotifyDemo {
	// 主函数,启动存取线程
	public static void main(String[] args) {
		// 生产/消费线程交换对象的的队列
		List<Object> shareList = new java.util.LinkedList<Object>();
		// 启动生产线程
		new ProduceThread(shareList).start();
		// 启动消费线程
		new CustomerThread(shareList).start();
	}

}
