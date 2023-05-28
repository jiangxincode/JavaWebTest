package com.yuqiaotech.helloj2ee.hibernate.misc;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * 本例用来演示Hibernate的Interceptor。
 * 本例还有个作业：把本例完善，比如打印新增信息的时候需要显示实体类的名称，比如User，应该显示“新增[用户]详细信息为:xxxx”，
 * 而修改时需要显示变化的属性名，如如果修改了User的username属性，默认是记录username:xxx->yyy，现在要求显示为：
 * 用户名[username]:xxx->yyy。 这个功能要求结合annotation的知识来实现，或则直接使用
 * /com/yuqiaotech/simplejee/javase/annotation/Comment.java
 * 在User中添加annotation，然后在本类里写代码读取。
 */
public class EntityUpdateInterceptor extends EmptyInterceptor {
	private final Log log = LogFactory.getLog(EntityUpdateInterceptor.class);

	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (!log.isDebugEnabled())
			return false;
		String toStr = ToStringBuilder.reflectionToString(entity);
		log.debug(toStr);
		return false;
	}

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if (!log.isDebugEnabled())
			return false;
		String operationLog = "";
		for (int i = 0; i < types.length; i++) {
			if (currentState[i] == previousState[i])
				continue;
			if (currentState[i] != null && currentState[i].equals(previousState[i]))
				continue;
			if (currentState[i] == null && "".equals(previousState[i])
					|| previousState[i] == null && "".equals(currentState[i]))
				continue;
			operationLog += propertyNames[i] + ":" + previousState[i] + "=>" + currentState[i] + " ";
		}
		log.debug(operationLog);
		return false;
	}

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (!log.isDebugEnabled())
			return;
		String toStr = ToStringBuilder.reflectionToString(entity);
		log.debug(toStr);
	}

}
