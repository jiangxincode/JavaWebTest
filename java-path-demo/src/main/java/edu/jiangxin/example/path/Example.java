package edu.jiangxin.example.path;

import java.io.InputStream;
import java.net.URL;

public class Example {

	public static void main(String[] args) {

		// eclipse中执行："D:/temp/Java/PathExample/target/classes/edu/jiangxin/example/path/config01.xml"
		// java -jar执行: "D:/temp/Java/PathExample/target/PathExample-0.0.1-SNAPSHOT.jar!/edu/jiangxin/example/path/config01.xml"
		URL url = Example.class.getResource("config01.xml");
		System.out.println(url);
		// eclipse和java -jar方式都可以读取
		InputStream inputStream = Example.class.getResourceAsStream("config01.xml");
		System.out.println(inputStream);

		url = Example.class.getResource("dir01/config01.xml");
		System.out.println(url);
		inputStream = Example.class.getResourceAsStream("dir01/config01.xml");
		System.out.println(inputStream);

		// eclipse中执行："D:/temp/Java/PathExample/target/classes/"
		// java -jar执行url为null
		url = Example.class.getResource("/");
		System.out.println(url);
		// eclipse中可以读取，java -jar执行inputStream为null
		inputStream = Example.class.getResourceAsStream("/");
		System.out.println(inputStream);

		// eclipse中执行："D:/temp/Java/PathExample/target/classes/config02.xml"
		// java -jar执行: "D:/temp/Java/PathExample/target/PathExample-0.0.1-SNAPSHOT.jar!/config02.xml"
		url = Example.class.getResource("/config02.xml");
		System.out.println(url);
		// eclipse和java -jar方式都可以读取
		inputStream = Example.class.getResourceAsStream("/config02.xml");
		System.out.println(inputStream);

		System.out.println("=====================================================================");

		// eclipse中执行："D:/temp/Java/PathExample/target/classes/config02.xml"
		// java -jar执行: "D:/temp/Java/PathExample/target/classes/config02.xml"	
		url = Example.class.getClassLoader().getResource("config02.xml");
		System.out.println(url);
		// eclipse和java -jar方式都可以读取
		inputStream = Example.class.getClassLoader().getResourceAsStream("config02.xml");
		System.out.println(inputStream);

		//由于"Example.class.getResource("/")"已经代表"D:/temp/Java/PathExample/target/classes/"
		//所以如果在前面再加个"/"会返回null
		url = Example.class.getClassLoader().getResource("/");
		System.out.println(url);
		inputStream = Example.class.getClassLoader().getResourceAsStream("/");
		System.out.println(inputStream);

		//eclipse中执行："D:/temp/Java/PathExample/target/classes/"
		//java -jar执行: "D:/temp/Java/PathExample/target/PathExample-0.0.1-SNAPSHOT.jar"	
		url = Example.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(url);

	}

}
