package hibernate1.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Administrator
 * 
 *         TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת�� ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	/*------------�����¶���-----------------*/
	public static void saveObj(Object o) {
		try {
			session = HibernateUtil.currentSession(); // ��������
			tx = session.beginTransaction(); // ��������
			session.save(o);

			tx.commit();

		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null)
				HibernateUtil.closeSession(session);
		}
	}

	/*------------ɾ������-----------------*/
	public static void delObject(Object o) {
		try {
			session = HibernateUtil.currentSession(); // ��������
			Transaction tx = session.beginTransaction(); // ��������
			session.delete(o);
			tx.commit();

		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/*------------�޸Ķ���-----------------*/
	public static void updateObj(Object o) {
		try {
			session = HibernateUtil.currentSession(); // ��������
			Transaction tx = session.beginTransaction(); // ��������
			session.update(o);
			tx.commit();

		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}
}
