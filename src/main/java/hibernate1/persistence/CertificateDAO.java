package hibernate1.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate1.model.Certificate;

/**
 * @author Administrator
 * 
 *         TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class CertificateDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	/*------------取得所有的学生列表-----------------*/
	// public static List getAllStu() {
	// List list=null;
	// try {
	// session = HibernateUtil.currentSession(); //开启连接
	// tx = session.beginTransaction(); //开启事务
	// Query q=session.createQuery("from Student");
	// list=q.list();
	// Student stu=(Student) list.get(0);
	// System.out.println(Hibernate.isInitialized(stu));
	// tx.commit();
	//
	// } catch (HibernateException e) { //捕捉例外
	// e.printStackTrace();
	// tx.rollback();
	// }finally
	// {
	// HibernateUtil.closeSession(session);
	// }
	// return list;
	//
	// }
	/*------------取得一个学生-----------------*/
	public static Certificate getOneCer() {
		Certificate cer = null;
		try {
			session = HibernateUtil.currentSession(); // 开启连接
			tx = session.beginTransaction(); // 开启事务
			cer = (Certificate) session.get(Certificate.class, "ff80808105384a980105384a9ba60001");
			tx.commit();

		} catch (HibernateException e) { // 捕捉例外
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return cer;

	}

}
