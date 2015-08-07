package com.shengsiyuan.junit3;

import com.shengsiyuan.junit3.MyStack;

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class MyStackTest extends TestCase {
	private MyStack myStack;

	@Override
	public void setUp() throws Exception {
		myStack = new MyStack();
	}

	public void testPush() {
		try {
			myStack.push("hello world");
		} catch (Exception e) {
			Assert.fail();
		}

		String result = null;

		try {
			result = myStack.pop();
		} catch (Exception ex) {

		}

		Assert.assertEquals("hello world", result);
	}

	public void testPush2() {
		for (int i = 0; i < 100; i++) {
			try {
				myStack.push(i + "");
			} catch (Exception ex) {
				Assert.fail();
			}
		}

		for (int i = 0; i < 100; i++) {
			String result = null;

			try {
				result = myStack.pop();
			} catch (Exception ex) {

			}

			Assert.assertEquals((99 - i) + "", result);
		}
	}

	public void testPush3() {
		Exception tx = null;

		try {
			for (int i = 0; i <= 100; i++) {
				myStack.push(i + "");
			}

			Assert.fail();
		} catch (Exception ex) {
			tx = ex;
		}

		assertData(tx);
	}

	public void testPop() {
		try {
			myStack.push("hello world");
		} catch (Exception e) {

		}

		String result = null;

		try {
			result = myStack.pop();
		} catch (Exception ex) {
			Assert.fail();
		}

		Assert.assertEquals("hello world", result);
	}

	public void testPop2() {
		Throwable tx = null;

		try {
			myStack.pop();

			Assert.fail();
		} catch (Exception ex) {
			tx = ex;
		}

		assertData(tx);
	}

	public void testPop3() {
		Throwable tx = null;

		try {
			myStack.push("hello");
		} catch (Exception ex) {

		}

		try {
			myStack.pop();
			myStack.pop();

			Assert.fail();
		} catch (Exception ex) {
			tx = ex;
		}

		assertData(tx);
	}

	public void testTop() {
		try {
			myStack.push("hello");
		} catch (Exception ex) {

		}

		String result = null;

		try {
			result = myStack.top();
		} catch (Exception ex) {
			Assert.fail();
		}

		Assert.assertEquals("hello", result);
	}

	public void testTop2() {
		Throwable tx = null;

		try {
			myStack.top();

			Assert.fail();
		} catch (Exception ex) {
			tx = ex;
		}

		assertData(tx);
	}

	public void testDelete() {
		try {
			for (int i = 0; i < 10; i++) {
				myStack.push(i + "");
			}

			myStack.delete(10);
		} catch (Exception ex) {
			Assert.fail();
		}
	}

	public void testDelete2() {
		Throwable tx = null;

		try {
			for (int i = 0; i < 10; i++) {
				myStack.push(i + "");
			}

			myStack.delete(11);

			Assert.fail();
		} catch (Exception ex) {
			tx = ex;
		}

		assertData(tx);
	}

	private void assertData(Throwable tx) {
		Assert.assertNotNull(tx);
		Assert.assertEquals(Exception.class, tx.getClass());
		Assert.assertEquals("数组越界异常!", tx.getMessage());
	}

}
