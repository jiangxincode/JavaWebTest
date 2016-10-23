package com.yuqiaotech.helloj2ee.hibernate.misc;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * 这个用法是为了线程安全，也是TheadLocal的一个演示。 另外在minimvc里也用到了TheadLocal。
 * 
 * 如果你在写代码时需要在一次线程中调用多个方法，而多个方法里都涉及数据库操作，那么你要考虑事务的事情。
 * 那问题就来了，在哪里创建session，在哪里关闭session。
 * 一个方法是在你程序的开始创建session，然后调用完所有的方法，然后关闭session，
 * 但这里存在很多问题，一个是你需要把这个session对象放在函数的参数里传来传去，另外很多情况，搞不清楚程序的开始和结束。
 * 使用TheadLocal可以很舒服的解决这个问题。TheadLocal就像一个线程内的静态变量一样。
 * 你可以在需要的时候，创建session，然后放到一个静态的TheadLocal里，然后在任何地方从该TheadLocal里获取该session，
 * 而不和其他线程发生冲突。用起来就像静态变量一样，以省去你将一个在很多地方都需要的对象，传来传去。
 * 
 * struts2，spring也大量使用了TheadLocal。
 * 
 */
public class ThreadHibernateUtil {
	public static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal<Session> threadLocalForSession = new ThreadLocal<Session>();

	public static Session currentSession() throws HibernateException {
		Session s = threadLocalForSession.get();
		if (s == null) {
			s = sessionFactory.openSession();
			threadLocalForSession.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = threadLocalForSession.get();
		if (s != null) {
			s.close();
		}
		threadLocalForSession.set(null);
	}
}