package edu.jiangxin.time;

import java.util.Timer;
import java.util.TimerTask;

public class CustomizedTimerTask extends TimerTask {

	private static int count = 0;

	@Override
	public void run() {
		System.out.println("The customized TimeTask is invoked. Count: " + (++count));
	}

	/**
	 * delay in milliseconds before task is to be executed.
	 */
	private static final long DELAY = 1000;

	/**
	 * period time in milliseconds between successive task executions.
	 */
	private static final long PERIOD = 1000;

	public static void main(String[] args) {

		Timer timer = new Timer();
		timer.schedule(new CustomizedTimerTask(), DELAY, PERIOD);
	}
}