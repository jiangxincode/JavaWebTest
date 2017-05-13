package hibernate2.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate2.model.Student;
import hibernate2.model.Team;

/**
 * @author Administrator
 * 
 *         TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת�� ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class TeamDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	public static void cascadeDelete_orphan() {
		Team team = null;
		try {
			session = HibernateUtil.currentSession(); // ��������
			tx = session.beginTransaction();
			team = (Team) session.get(Team.class, "ff80808105416d3b0105416d3eca0002");
			Student removeStu = (Student) session.get(Student.class, "ff80808105416d3b0105416d3eca0001");
			team.getStudents().remove(removeStu); // ��ѧ����������ȥremoveStu
			removeStu.setName("remove name");// Ϊ���Ƴ��Ķ����������

			tx.commit();

		} catch (HibernateException e) { // ��׽����
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
