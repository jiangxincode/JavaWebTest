package com.yuqiaotech.helloj2ee.spring;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP的一种简单用法。 这里也演示了commons-logging的用法，关于logging请参看src下的log4j.xml。
 *
 */
public class LoggingAop {
	private static final Log logger = LogFactory.getLog(LoggingAop.class);

	public void loggingBefore(GreetingService greetingService) {
		logger.info("------------------loggingBefore:class name is " + greetingService.getClass());
		logger.info(new Date());
	}

	public void loggingAfter(GreetingService greetingService) {
		logger.info("=================loggingAfter:");
		logger.info(new Date());
	}

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("###################Logging before " + joinPoint.getSignature().getName());
		Object retVal = joinPoint.proceed();
		logger.info("*******************Logging after " + joinPoint.getSignature().getName());
		return retVal;
	}

	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		System.out.println("Logging when throwing " + joinPoint.getSignature().getName());
	}
}
