package com.yuqiaotech.helloj2ee.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HelloHibernate {
	public static void main(String[] args) {
		// 新增，修改，删除
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Message message = new Message();
		message.setTitle("test");
		message.setText("msg content");
		Long msgId = (Long) session.save(message);
		Message mx = (Message) session.get(Message.class, msgId);
		mx.setText("update");
		session.save(mx);
		mx.setText("updatexxx");
		session.save(mx);
		session.delete(mx);
		tx.commit();
		session.close();
		
		// HQL查询
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		Query q = newSession.createQuery(
				// select * from messages m order by m.message_text asc
				"from Message m order by m.text asc");
		List messages = q.list();
		System.out.println(messages.size() + " message(s) found:");

		for (Iterator iter = messages.iterator(); iter.hasNext();) {
			Message loadedMsg = (Message) iter.next();
			System.out.println(loadedMsg.getId() + "=" + loadedMsg.getText());
		}
		newTransaction.commit();
		newSession.close();

		// HQL修改
		Session newSessionUpdateQuery = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransactionUpdateQuery = newSessionUpdateQuery.beginTransaction();
		Query updateQuery = newSessionUpdateQuery.createQuery("update Message set text='update text2' where id>3");
		updateQuery.executeUpdate();
		System.out.println(" update query");
		Iterator iter = newSessionUpdateQuery.createQuery("from Message m order by m.text asc").iterate();
		for (; iter.hasNext();) {
			Message loadedMsg = (Message) iter.next();
			Class clazz = loadedMsg.getClass();
			System.out.println("HelloHibernate.main()" + clazz);
			System.out.println(loadedMsg.getId() + "=" + loadedMsg.getText());
		}
		newTransactionUpdateQuery.commit();
		newSessionUpdateQuery.close();

		// Shutting down the application
		HibernateUtil.shutdown();
	}
}
