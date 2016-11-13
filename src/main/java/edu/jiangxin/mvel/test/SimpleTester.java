package edu.jiangxin.mvel.test;

import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.compiler.ExecutableAccessor;

public class SimpleTester {

	public static void main(String[] args) {

		Person person = new Person();
		person.setName("Mr.Foo");

		// 判断相等
		Object objResult = MVEL.eval("name == 'Mr.Foo'", person);
		System.out.println("objResult=" + objResult);

		// 取值
		String strResult = (String) MVEL.eval("name", person);
		System.out.println("strResult=" + strResult);

		// 计算
		Map<String, Integer> vars = new HashMap<String, Integer>();
		vars.put("x", new Integer(5));
		vars.put("y", new Integer(10));

		// 第一种方式
		Integer intResult = (Integer) MVEL.eval("x * y", vars);
		System.out.println("intResult=" + intResult);

		// 第二种方式
		ExecutableAccessor compiled = (ExecutableAccessor) MVEL.compileExpression("x * y");
		intResult = (Integer) MVEL.executeExpression(compiled, vars);
		System.out.println("intResult=" + intResult);

	}
}
