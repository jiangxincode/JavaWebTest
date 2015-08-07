package com.shengsiyuan.junit4;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class LargestTest {
	private Largest largest;

	@Before
	public void setUp() throws Exception {
		largest = new Largest();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLargest() {
		int[] array = { 1, 9, -10, -20, 23, 34 };

		int result = 0;

		try {
			result = largest.getLargest(array);
		} catch (Exception ex) {
			fail("测试失败");
		}

		Assert.assertEquals(34, result);
	}

	@Test(expected = Exception.class)
	public void testGetLargest2() throws Exception {
		largest.getLargest(null);
	}

	@Test(expected = Exception.class)
	// @Ignore("not ready yet")
	public void testGetLargest3() throws Exception {
		largest.getLargest(new int[] {});
	}

}
