package hibernate1.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate1.model.Certificate;

/**
 * @author Administrator
 * 
 *         TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת�� ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class CertificateDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	/*------------ȡ�����е�ѧ���б�-----------------*/
	// public static List getAllStu() {
	// List list=null;
	// try {
	// session = HibernateUtil.currentSession(); //��������
	// tx = session.beginTransaction(); //��������
	// Query q=session.createQuery("from Student");
	// list=q.list();
	// Student stu=(Student) list.get(0);
	// System.out.println(Hibernate.isInitialized(stu));
	// tx.commit();
	//
	// } catch (HibernateException e) { //��׽����
	// e.printStackTrace();
	// tx.rollback();
	// }finally
	// {
	// HibernateUtil.closeSession(session);
	// }
	// return list;
	//
	// }
	/*------------ȡ��һ��ѧ��-----------------*/
	public static Certificate getOneCer() {
		Certificate cer = null;
		try {
			session = HibernateUtil.currentSession(); // ��������
			tx = session.beginTransaction(); // ��������
			cer = (Certificate) session.get(Certificate.class, "ff80808105384a980105384a9ba60001");
			tx.commit();

		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return cer;

	}

}
