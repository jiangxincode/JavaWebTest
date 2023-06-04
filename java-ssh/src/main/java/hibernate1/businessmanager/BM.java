package hibernate1.businessmanager;

import org.hibernate.HibernateException;

import hibernate1.model.Certificate;
import hibernate1.model.Student;
import hibernate1.persistence.StudentDAO;

public class BM {
	public static void main(String[] args) throws HibernateException {
		
		Student stu = new Student();
		stu.setName("spark");
		stu.setCardId("200211332");
		stu.setAge(33);

		Certificate cer = new Certificate();
		cer.setDescribe("spark");

		// 设定学生与身份证之间的关联关系
		stu.setCer(cer);
		cer.setStu(stu);

		StudentDAO.saveObj(stu);
	}

}
