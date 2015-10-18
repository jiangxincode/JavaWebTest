/*
 * 创建日期 2005-7-2
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.Student;

import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Administrator
 * 
 *         TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class StudentDAO extends BaseDAO {
	static Session session = null;
	static Transaction tx = null;

	public static void update() {
		Student stu = null;
		try {
			session = HibernateUtil.currentSession(); // 开启连接
			tx = session.beginTransaction(); // 开启事务
			Query query = session.getNamedQuery("queryStudent_byAgeAdnName");

			query.setInteger("minAge", 25); // 设置“:”号后的minAge变量值
			query.setString("likeName", "%clus%");// 设置“:”号后的likeName变量值

			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				stu = (Student) list.get(i);
				System.out.println(stu.getName());
			}

			tx.commit();

		} catch (HibernateException e) { // 捕捉例外
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}
