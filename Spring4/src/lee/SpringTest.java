package lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {

	public final static String CHINESE = "Chinese";

	public final static String AMERICAN = "American";

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("applicationContext.xml");

		System.out.println("=============");

		Person p = (Person) ctx.getBean("chinese");

		p.test();
	}

}
