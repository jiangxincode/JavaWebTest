package edu.jiangxin.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyProcess {
	
	/**
	 * 取得属性
	 * @param classType
	 * @param key
	 * @return
	 */
	public static String getProperty(Class<?> classType, String key) {
		
		Object value = null;
		
		try {
			Method method = classType.getMethod("getProperty", new Class[]{String.class});
			value = method.invoke(classType, key);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return (String)value;
	}
	
	/**
	 * 设置属性
	 * @param classType
	 * @param key
	 * @param value
	 */
	public static void setProperty(Class<?> classType, String key, String value) {
		try {
			Method method = classType.getMethod("setProperty", new Class[]{String.class, String.class});
			method.invoke(classType, key, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
