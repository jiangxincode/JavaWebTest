package persistence;

import java.util.HashSet;
import java.util.Set;

import model.Course;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	public static void mdfChoice() {
		Set set = new HashSet();

		Student stu = null;
		Course course = null;

		try {
			session = HibernateUtil.currentSession(); // ��������

			tx = session.beginTransaction(); // ��������

			stu = (Student) session.createQuery("from Student s where s.name ='tomclus'").uniqueResult();

			course = (Course) session.createQuery("from Course c where c.name='ecnomic'").uniqueResult();

			stu.getCourses().add(course);
			course.getStudents().add(stu);

			tx.commit();
		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
