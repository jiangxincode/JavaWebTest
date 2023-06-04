package hibernate2.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate2.model.Student;
import hibernate2.model.Team;

/**
 * @author Administrator
 * 
 *         TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class TeamDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	public static void cascadeDelete_orphan() {
		Team team = null;
		try {
			session = HibernateUtil.currentSession(); // 开启连接
			tx = session.beginTransaction();
			team = (Team) session.get(Team.class, "ff80808105416d3b0105416d3eca0002");
			Student removeStu = (Student) session.get(Student.class, "ff80808105416d3b0105416d3eca0001");
			team.getStudents().remove(removeStu); // 从学生集合中移去removeStu
			removeStu.setName("remove name");// 为被移除的对象更改名字

			tx.commit();

		} catch (HibernateException e) { // 捕捉例外
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
