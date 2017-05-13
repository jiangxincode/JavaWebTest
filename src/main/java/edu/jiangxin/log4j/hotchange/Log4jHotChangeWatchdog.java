package edu.jiangxin.log4j.hotchange;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class Log4jHotChangeWatchdog {
	public static Logger logger = Logger.getLogger(Log4jHotChangeWatchdog.class);
	static {
		PropertyConfigurator.configureAndWatch("./log4j.properties", 60000);
	}

	public static void printLog() {
		if (logger.isDebugEnabled()) {
			logger.debug("debug!!");
		}
		if (logger.isInfoEnabled()) {
			logger.info("info!!");
		}
		logger.error("error!!");
	}

	public static void main(String[] args) {
		while (!Thread.interrupted()) {
			Log4jHotChangeWatchdog.printLog();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
