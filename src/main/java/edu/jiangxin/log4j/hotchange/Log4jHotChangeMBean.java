package edu.jiangxin.log4j.hotchange;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 基于JMX动态配置Log4J日志级别，并控制Trace开关的MBean.
 */
@Component
@ManagedResource(objectName = Log4jHotChangeMBean.MBEAN_NAME, description = "Log4j Management Bean")
public class Log4jHotChangeMBean {

	/**
	 * Log4jManager的Mbean的注册名称.
	 */
	public static final String MBEAN_NAME = "log4j:name=Log4j";

	private static Logger managerLogger = LogManager.getLogger(Log4jHotChangeMBean.class);

	private String projectLoggerName;

	@ManagedAttribute(description = "Level of the root logger")
	public String getRootLoggerLevel() {
		Logger logger = Logger.getRootLogger();
		//      MBeanServer server = MBeanServerFactory.createMBeanServer();
		return logger.getEffectiveLevel().toString();
	}

	@ManagedAttribute
	public void setRootLoggerLevel(String newLevel) {
		Logger logger = Logger.getRootLogger();
		Level level = Level.toLevel(newLevel);
		logger.setLevel(level);
		managerLogger.info("设置Root Logger 级别为" + newLevel);
	}

	/**
	 * 获得项目默认logger的级别.
	 * 项目默认logger名称通过#setProjectLoggerName(String)配置.
	 */
	@ManagedAttribute(description = "Level of the project default package logger")
	public String getProjectLoggerLevel() {
		if (projectLoggerName != null) {
			return getLoggerLevel(projectLoggerName);
		}

		return null;
	}

	/**
	 * 设置项目默认logger的级别.
	 * 项目默认logger名称通过#setProjectLoggerName(String)配置.
	 */
	@ManagedAttribute
	public void setProjectLoggerLevel(String newLevel) {
		if (projectLoggerName != null) {
			setLoggerLevel(projectLoggerName, newLevel);
		}
	}

	/**
	 * 获取Logger的日志级别.
	 */
	@ManagedOperation(description = "Get logging level of the logger")
	@ManagedOperationParameters({ @ManagedOperationParameter(name = "loggerName", description = "Logger name") })
	public String getLoggerLevel(String loggerName) {
		Logger logger = Logger.getLogger(loggerName);
		return logger.getEffectiveLevel().toString();
	}

	/**
	 * 设置Logger的日志级别.
	 * 如果日志级别名称错误, 设为DEBUG.
	 */
	@ManagedOperation(description = "Set new logging level to the logger")
	@ManagedOperationParameters({ @ManagedOperationParameter(name = "loggerName", description = "Logger name"),
			@ManagedOperationParameter(name = "newlevel", description = "New level") })
	public void setLoggerLevel(String loggerName, String newLevel) {
		Logger logger = Logger.getLogger(loggerName);
		Level level = Level.toLevel(newLevel);
		logger.setLevel(level);
		managerLogger.info("设置" + loggerName + "级别为" + newLevel);
	}

	/**
	 * 根据log4j.properties中的定义, 设置项目默认的logger名称
	 */
	public void setProjectLoggerName(String projectLoggerName) {
		this.projectLoggerName = projectLoggerName;
	}

	public static void main(String[] args) {
		String loggerName = "org.springside.modules";
		Log4jHotChangeMBean mbean = new Log4jHotChangeMBean();
		String orgLevel = mbean.getLoggerLevel(loggerName);

		Logger.getLogger(loggerName).setLevel(Level.FATAL);
		System.out.println(mbean.getLoggerLevel(loggerName));

		mbean.setLoggerLevel(loggerName, "TRACE");
		System.out.println(mbean.getLoggerLevel(loggerName));

		mbean.setLoggerLevel(loggerName, "WRONG_LEVEL_NAME");
		System.out.println(mbean.getLoggerLevel(loggerName));

		mbean.setLoggerLevel(loggerName, orgLevel);
	}

}