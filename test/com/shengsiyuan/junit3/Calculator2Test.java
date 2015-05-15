package com.shengsiyuan.junit3;

import java.lang.reflect.Method;

import com.shengsiyuan.junit3.Calculator2;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Calculator2Test extends TestCase {
	public void testAdd() {
		try {
			Calculator2 cal2 = new Calculator2();

			Class<Calculator2> clazz = Calculator2.class;

			Method method = clazz.getDeclaredMethod("add", new Class[] {
					Integer.TYPE, Integer.TYPE });

			method.setAccessible(true);

			Object result = method.invoke(cal2, new Object[] { 2, 3 });

			Assert.assertEquals(5, result);

		} catch (Exception ex) {
			Assert.fail();
		}

	}
}
