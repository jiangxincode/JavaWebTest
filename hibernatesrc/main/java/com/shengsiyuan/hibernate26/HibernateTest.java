package com.shengsiyuan.hibernate26;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure(HibernateTest.class.getResource("hibernate.cfg.xml"))
					.buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Team team = new Team();
			team.setTeamName("team2");

			for (int i = 0; i < 1200; i++) {
				Student student = new Student();

				student.setAge(30);
				student.setCardId("123456");
				student.setName("student" + i);
				student.setTeam(team);

				team.getStudents().add(student);
			}

			session.save(team);
			tx.commit();

			Session session1 = sessionFactory.openSession();
			Transaction tx1 = session1.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Student> list = session.createQuery("from Student s order by s.name asc").list();

			for (Student student : list) {
				System.out.println(student.getName());
			}

			tx1.commit();

			System.out.println("------------------------------");

			Session session2 = sessionFactory.openSession();
			Transaction tx2 = session2.beginTransaction();

			Student s1 = (Student) session2.get(Student.class, "402881ea2ed79f97012ed79f9a710206");
			Student s2 = (Student) session2.get(Student.class, "402881ea2ed79f97012ed79f9a8102ab");

			System.out.println(s1.getName());
			System.out.println(s2.getName());

			tx2.commit();


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
