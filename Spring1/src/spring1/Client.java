package spring1;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Client {
	public static void main(String[] args) {
		ClassPathResource cpr = new ClassPathResource("applicationContext.xml");

		XmlBeanFactory factory = new XmlBeanFactory(cpr);
		
		Person chinese = (Person)factory.getBean("chinese");
		
		System.out.println(chinese.sayHello("张三"));
		System.out.println(chinese.sayGoodBye("张三"));

	}
}
