package hibernate2.BusinessManager;

import org.hibernate.HibernateException;

import hibernate2.model.Certificate;
import hibernate2.model.Student;
import hibernate2.persistence.StudentDAO;

/**
 * @author Administrator
 * 
 *         TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת�� ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class BM {
	public static void main(String[] args) throws HibernateException {
		Student stu = new Student();

		stu.setName("tom");
		stu.setCardId("200254321");
		stu.setAge(33);

		Certificate cer = new Certificate();
		cer.setDescribe("tom");

		stu.setCer(cer);
		cer.setStu(stu);

		StudentDAO.saveObj(stu);
	}

}
