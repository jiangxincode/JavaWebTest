package edu.jiangxin.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringProcessTest {
	
	StringProcess stringProcess = null;

	@Before
	public void setUp() throws Exception {
		stringProcess = new StringProcess();
	}

	@Test
	public void testCheckVaild() {
		assertTrue(stringProcess.checkValid("${IP}:${PORT}/console"));
		assertFalse(stringProcess.checkValid(null));
		assertFalse(stringProcess.checkValid(""));
		assertFalse(stringProcess.checkValid("${$}"));
	}
	
	@Test
	public void testParser01() {
		PropertyProcess.setProperty(System.class, "IP", "127.0.0.1");
		PropertyProcess.setProperty(System.class, "PORT", "8080");
		
		String input = "${IP}:${PORT}/console";
		String expect = "127.0.0.1:8080/console";
		assertEquals(expect, stringProcess.parser(input));
	}

}
