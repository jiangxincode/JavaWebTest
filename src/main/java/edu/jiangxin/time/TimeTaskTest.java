package edu.jiangxin.time;

import java.util.Timer;

public class TimeTaskTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new Task(), 6 * 10);
	}
}