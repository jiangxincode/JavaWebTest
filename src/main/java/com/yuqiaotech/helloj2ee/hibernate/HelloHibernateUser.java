package com.yuqiaotech.helloj2ee.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * hibernate的基本使用的演示。 在调试模式下运行，以便查看每一步后数据库里的变化。
 * 和HelloHibernate相比，这里没有关联，不是使用的XML做配置，而是JPA。
 * 
 * @author YUQAIO
 * 
 */
public class HelloHibernateUser {
	public static void main(String[] args) {

		save();

		// Shutting down the application
		HibernateUtil.shutdown();
	}

	private static void save() {
		// First unit of work
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setUsername("Tom");
		Long userId = (Long) session.save(user);// user是瞬态的

		User userx = new User();
		userx.setUsername("Tomxx");
		session.persist(userx);

		User usery = new User();
		usery.setUsername("Tomzz");
		session.save(usery);// user是瞬态的

		User user2 = (User) session.get(User.class, userId);
		System.out.println("user2 == " + (user == user2));

		user2.setUsername("Jack");
		session.save(user2);// user2是持久态的

		User user3 = new User();
		user3.setId(userId);// 没有用途
		user3.setUsername("Mike");
		session.save(user3);// user3是瞬态的，虽然id有值。

		User user4 = new User();
		user4.setId(userId);
		user4.setUsername("Mary");
		User user4x = (User) session.merge(user4);// 这里调的是merge，针对瞬态，但有ID的情况
		System.out.println("user4 == " + (user4x == user4));

		User user5 = new User();
		user5.setUsername("Maryx");
		session.merge(user5);// 这里调的是merge，针对瞬态，而且id没有值。

		// session.delete(user2);
		tx.commit();
		session.close();

	}

	private static void query() {

		// Second unit of work
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		List<User> users = newSession.createQuery("from User m order by username asc").list();
		System.out.println(users.size() + " user(s) found:");

		for (Iterator iter = users.iterator(); iter.hasNext();) {
			User loadedUser = (User) iter.next();
			System.out.println(loadedUser.getId() + "=" + loadedUser.getUsername());
		}
		newTransaction.commit();
		newSession.close();

		// Third unit of work
		Session newSessionUpdateQuery = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransactionUpdateQuery = newSessionUpdateQuery.beginTransaction();
		Query updateQuery = newSessionUpdateQuery.createQuery("update User set username='Tom' where id>1");
		int affected = updateQuery.executeUpdate();
		System.out.println(" update query ");
		users = newSessionUpdateQuery.createQuery("from User u order by u.username asc").list();
		for (Iterator iter = users.iterator(); iter.hasNext();) {
			User loadedUser = (User) iter.next();
			System.out.println(loadedUser.getId() + "=" + loadedUser.getUsername());
		}
		newTransactionUpdateQuery.commit();
		newSessionUpdateQuery.close();

	}

	private static void save2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user2 = (User) session.get(User.class, 60l);
		user2.setUsername("Tomxxxxxxdddxxxxxx");
		session.save(user2);
		session.flush();
		session.close();
	}
}
