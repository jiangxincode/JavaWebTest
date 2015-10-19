package lee;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {
	public static void main(String[] args) throws Exception {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

		System.out.println("程序已经实例化BeanFactory...");

		Person p = (Person) factory.getBean("chinese");

		System.out.println("程序中已经完成了chinese bean的实例化...");

		p.useAxe();
	}
}