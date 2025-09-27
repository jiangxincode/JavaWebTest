package edu.jiangxin.replace;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigASTest {
	
	@Before
	public void setUp() {
		System.setProperty("IP", "127.0.0.1");
		System.setProperty("PORT", "4120");
		System.setProperty("PROTOCOL", "http");
	}
	
	@Test
	public void testGetVariableAfterReplaced() {
		
		//正常替换
		Assert.assertEquals("http:abcdefg", ConfigAS.getVariableAfterReplaced("${PROTOCOL}:abcdefg"));
		
		//正常多组替换
		Assert.assertEquals("http://127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}:${PORT}"));
		Assert.assertEquals("httphttphttphttp", ConfigAS.getVariableAfterReplaced("${PROTOCOL}${PROTOCOL}${PROTOCOL}${PROTOCOL}"));
		Assert.assertEquals("http://127.0.0.1:4120/console/", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}:${PORT}/console/"));
		
		//读取不存在的系统特性时不进行替换，但不影响其它特性的替换
		Assert.assertEquals("http://127.0.0.1:${WHO}/console/", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}:${WHO}/console/"));
		Assert.assertEquals("http://127.0.0.1:${}", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}:${}"));
		Assert.assertEquals("http://127.0.0.1:${ }", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}:${ }"));
		
		//出现单独的"$/{/}"，但是没有出现"${"时不进行替换，但不影响其它特性的替换
		Assert.assertEquals("$adf{PROTOCOL}://127.0.0.1:4120/console/", ConfigAS.getVariableAfterReplaced("$adf{PROTOCOL}://${IP}:${PORT}/console/"));
		Assert.assertEquals("$http://127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("$${PROTOCOL}://${IP}:${PORT}"));
		Assert.assertEquals("http://$127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://$${IP}:${PORT}"));
		Assert.assertEquals("http://{}127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://{}${IP}:${PORT}"));
		Assert.assertEquals("http://{127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://{${IP}:${PORT}"));
		Assert.assertEquals("http://}127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://}${IP}:${PORT}"));
		Assert.assertEquals("http://$}127.0.0.1:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://$}${IP}:${PORT}"));
		Assert.assertEquals("http://127.0.0.1{:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}{:${PORT}"));
		Assert.assertEquals("http://127.0.0.1}:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}}:${PORT}"));
		Assert.assertEquals("http://127.0.0.1$}:4120", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}$}:${PORT}"));
		
		//${}中出现嵌套的$或者{视为语法错误，原值返回，不进行任何替换，即使其它特性的语法正确
		Assert.assertEquals("${$PROTOCOL}://${IP}:${PORT}/console/", ConfigAS.getVariableAfterReplaced("${$PROTOCOL}://${IP}:${PORT}/console/"));
		Assert.assertEquals("${{PROTOCOL}://${IP}:${PORT}/console/", ConfigAS.getVariableAfterReplaced("${{PROTOCOL}://${IP}:${PORT}/console/"));
		Assert.assertEquals("${${IP}PROTOCOL}://${IP}:${PORT}/console/", ConfigAS.getVariableAfterReplaced("${${IP}PROTOCOL}://${IP}:${PORT}/console/"));
		
		//有${却没有与之对应的}，原值返回，不进行任何替换，即使其它特性的语法正确
		Assert.assertEquals("${PROTOCOL}://${IP}:${PORT", ConfigAS.getVariableAfterReplaced("${PROTOCOL}://${IP}:${PORT"));
		
		
		
	}

}
