/*
 * �������� 2005-7-2
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package hibernate1.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate1.model.Student;

public class StudentDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	@SuppressWarnings("rawtypes")
	public static void update() {
		Student stu = null;
		try {
			session = HibernateUtil.currentSession(); // ��������
			tx = session.beginTransaction(); // ��������
			Query query = session.getNamedQuery("queryStudent_byAgeAdnName");

			query.setInteger("minAge", 25); // ���á�:���ź��minAge����ֵ
			query.setString("likeName", "%clus%");// ���á�:���ź��likeName����ֵ

			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				stu = (Student) list.get(i);
				System.out.println(stu.getName());
			}

			tx.commit();

		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
