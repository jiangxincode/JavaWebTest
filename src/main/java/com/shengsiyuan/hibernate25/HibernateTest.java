package com.shengsiyuan.hibernate25;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// Student student = new Student();
			//
			// student.setCardId("123456");
			// student.setAge(40);
			// student.setName("zhangsan");
			//
			// session.save(student);

			//			Session session1 = sessionFactory.openSession();
			//			Session session2 = sessionFactory.openSession();
			//
			//			Student student1 = (Student) session1.createQuery(
			//					"from Student s where s.name = :name").setString("name",
			//					"zhangsan").uniqueResult();
			//
			//
			//			Student student2 = (Student) session2.createQuery(
			//			"from Student s where s.name = :name").setString("name",
			//			"zhangsan").uniqueResult();
			//
			//			System.out.println(student1.getVersion());
			//			System.out.println(student2.getVersion());
			//
			//			Transaction tx1 = session1.beginTransaction();
			//
			//			student1.setName("lisi");
			//
			//			tx1.commit();
			//
			//			System.out.println(student1.getVersion());
			//			System.out.println(student2.getVersion());
			//
			//			Transaction tx2 = session2.beginTransaction();
			//
			//			student2.setName("wangwu");
			//
			//			tx2.commit();
			//
			//			session1.close();
			//			session2.close();

			Student student = new Student();

			student.setName("zhangsan");
			student.setCardId("123456");
			student.setAge(30);

			session.save(student);

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();

			if (null != tx) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
}
