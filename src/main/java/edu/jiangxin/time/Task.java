package edu.jiangxin.time;

import java.util.TimerTask;

public class Task extends TimerTask {
	public void run() {
		System.out.println("定时任务执行");
	}
}