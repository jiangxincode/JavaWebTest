package edu.jiangxin.time;

import java.util.TimerTask;

public class CustomizedTimerTask extends TimerTask {

	private static int count = 0;

	@Override
	public void run() {
		System.out.println("The customized TimeTask is invoked. Count: " + (++count));
	}
}