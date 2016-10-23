package com.yuqiaotech.helloj2ee.hibernate.sample1;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * 本例用来演示一对多关系。
 */
public class PersonAddressTest extends TestCase {
	public Session session = null;

	/**
	 * 准备session对象。
	 */
	public void setUp() {
		this.session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	}

	/**
	 * 清空原来的数据。
	 */
	private void clearData() {
		session.createQuery("delete from Address").executeUpdate();
		session.createQuery("delete from Person").executeUpdate();
	}

	/**
	 * 测试保存。
	 */
	public void testSave() {
		Transaction tr = this.session.beginTransaction();
		clearData();
		Person p = new Person();
		p.setName("aaa");
		p.setAge(22);
		Set addresses = new HashSet();
		// 如果用List呢？
		p.setAddress(addresses);

		Address a1 = new Address();
		a1.setName("gulouqu");
		a1.setZipcode("111111");
		a1.setPerson(p);// 可以不添加，但请用debug模式运行本例，观察save之后，a1的Person的区别。

		addresses.add(a1);

		Address a2 = new Address();
		a2.setName("xuanwuqu");
		a2.setZipcode("2222222");
		a2.setPerson(p);

		p.getAddress().add(a2);

		session.save(p);
		System.out.println("pid=[" + p.getPid() + "]");
		System.out.println("a1.id=[" + a1.getAid() + "]");
		System.out.println("a2.id=[" + a2.getAid() + "]");
		tr.commit();
		// 留意打印sql和打印这些调试语句的向后顺序。
		System.out.println("==pid=[" + p.getPid() + "]");
		System.out.println("==a1.id=[" + a1.getAid() + "]");
		System.out.println("==a2.id=[" + a2.getAid() + "]");
	}

	/**
	 * 留意查询出的对象的类型。
	 */
	public void testGet() {
		Person p = (Person) this.session.get(Person.class, "402881842bd7681b012bd76823660001");
		Set addresses = p.getAddress();
		Address add = (Address) addresses.iterator().next();
		add.getName();
		System.out.println("PersonAddressTest.testGet()");
	}

	/**
	 * 留意查询出的对象的类型并与上面的测试对比。
	 */
	public void testGet2() {
		Address add = (Address) this.session.get(Address.class, "402881842bd7681b012bd76823940002");
		Person p = add.getPerson();
		p.getName();
	}

	/**
	 * 使用hql进行delete。
	 */
	public void testHqlDelete() {
		String pid = "297e2a17271e84f801271e84fba00001";
		Transaction tr = this.session.beginTransaction();
		String hql = "delete from Person where id=?";
		Query q = this.session.createQuery(hql);
		q.setString(0, pid);
		q.executeUpdate();
		tr.commit();
	}

	/**
	 * delete对象。
	 */
	public void testDelete() {
		String pid = "297e2a17271e799301271e7996540001";
		Transaction tr = this.session.beginTransaction();
		Person p = (Person) session.get(Person.class, pid);
		session.delete(p);
		tr.commit();
	}

	protected void tearDown() throws Exception {
		session.close();
	}
}
