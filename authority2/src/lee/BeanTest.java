package lee;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {
	
	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		TestAction ta = (TestAction) factory.getBean("testAction");
		
		ta.view();
		ta.modify();
	}

}
