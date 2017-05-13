package hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			System.err.println("构造SessionFactory异常发生： " + ex.getMessage());
		}

	}

	public static Session currentSession() {
		Session session = sessionFactory.openSession();

		return session;
	}

	public static void closeSession(Session session) {
		if (null != session) {
			session.close();
		}
	}
}
