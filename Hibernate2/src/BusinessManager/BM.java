package BusinessManager;

import model.Certificate;
import model.Student;

import org.hibernate.HibernateException;

import persistence.StudentDAO;

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
