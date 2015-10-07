package lee;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {
	public static void main(String[] args) throws Exception {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

		System.out.println("�����Ѿ�ʵ����BeanFactory...");

		Person p = (Person) factory.getBean("chinese");

		System.out.println("�������Ѿ������chinese bean��ʵ����...");

		p.useAxe();
	}
}