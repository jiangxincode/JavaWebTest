package com.shengsiyuan.lesson082.observer;

public class ConcreteWatcher implements Watcher {
	@Override
	public void update(String str) {
		System.out.println(str);
	}

}
