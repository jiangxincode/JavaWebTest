package BusinessManager;

import model.Certificate;
import model.Student;

import org.hibernate.HibernateException;

import persistence.StudentDAO;

public class BM {
	public static void main(String[] args) throws HibernateException {
		
		Student stu = new Student();
		stu.setName("spark");
		stu.setCardId("200211332");
		stu.setAge(33);

		Certificate cer = new Certificate();
		cer.setDescribe("spark");

		// �趨ѧ�������֤֮��Ĺ�����ϵ
		stu.setCer(cer);
		cer.setStu(stu);

		StudentDAO.saveObj(stu);
	}

}
