package hibernate1.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Administrator
 * 
 *         TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	/*------------创建新对象-----------------*/
	public static void saveObj(Object o) {
		try {
			session = HibernateUtil.currentSession(); // 开启连接
			tx = session.beginTransaction(); // 开启事务
			session.save(o);

			tx.commit();

		} catch (HibernateException e) { // 捕捉例外
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null)
				HibernateUtil.closeSession(session);
		}
	}

	/*------------删除对象-----------------*/
	public static void delObject(Object o) {
		try {
			session = HibernateUtil.currentSession(); // 开启连接
			Transaction tx = session.beginTransaction(); // 开启事务
			session.delete(o);
			tx.commit();

		} catch (HibernateException e) { // 捕捉例外
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/*------------修改对象-----------------*/
	public static void updateObj(Object o) {
		try {
			session = HibernateUtil.currentSession(); // 开启连接
			Transaction tx = session.beginTransaction(); // 开启事务
			session.update(o);
			tx.commit();

		} catch (HibernateException e) { // 捕捉例外
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}
}
