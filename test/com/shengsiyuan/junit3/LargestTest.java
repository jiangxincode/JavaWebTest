package com.shengsiyuan.junit3;

import com.shengsiyuan.junit3.Largest;

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class LargestTest extends TestCase {
	private Largest largest;

	public void setUp() {
		largest = new Largest();
	}

	public void testGetLargest() {
		int[] array = { 1, 9, -10, -20, 23, 34 };

		int result = 0;

		try {
			result = largest.getLargest(array);
		} catch (Exception ex) {
			Assert.fail("����ʧ��");
		}

		Assert.assertEquals(34, result);
	}

	public void testGetLargest2() {
		Throwable tx = null;

		int[] array = {};

		try {
			largest.getLargest(array);

			Assert.fail("����ʧ��");
		} catch (Exception ex) {
			tx = ex;
		}

		Assert.assertNotNull(tx);

		Assert.assertEquals(Exception.class, tx.getClass());

		Assert.assertEquals("���鲻��Ϊ�գ�", tx.getMessage());
	}

	public void testGetLargest3() {
		Throwable tx = null;

		int[] array = null;

		try {
			largest.getLargest(array);

			Assert.fail();
		} catch (Exception ex) {
			tx = ex;
		}

		Assert.assertNotNull(tx);

		Assert.assertEquals(Exception.class, tx.getClass());

		Assert.assertEquals("���鲻��Ϊ�գ�", tx.getMessage());
	}
}
