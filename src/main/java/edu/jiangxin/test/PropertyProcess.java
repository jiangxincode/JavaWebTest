package edu.jiangxin.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyProcess {
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
}
