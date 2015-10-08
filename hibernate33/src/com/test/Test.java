package com.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			System.out.println("exception occured");
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void saveCustomerAndOrderWithCascade() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Customer customer = new Customer("zhangsan", new HashSet());

			Order order = new Order();
			order.setOrderNumber("zhangsan_order1");

			Order order2 = new Order();
			order2.setOrderNumber("zhangsan_order2");

			Order order3 = new Order();
			order3.setOrderNumber("zhangsan_order3");

			order.setCustomer(customer);
			order2.setCustomer(customer);
			order3.setCustomer(customer);

			customer.getOrders().add(order);
			customer.getOrders().add(order2);
			customer.getOrders().add(order3);

			session.save(customer);

			tx.commit();

		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}

	public static void deleteCategoryWithCascade() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Category category = (Category) session.load(Category.class, new Long(1));

			session.delete(category);

			tx.commit();

		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void saveCategoryWithCascade() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// 食品类别
			Category foodCategory = new Category("food", null, new HashSet());

			// 水果类别
			Category fruitCategory = new Category("fruit", null, new HashSet());

			// 蔬菜类别
			Category vegetableCategory = new Category("vegetable", null, new HashSet());

			// 苹果类别
			Category appleCategory = new Category("apple", null, new HashSet());

			// 桔子类别
			Category orangeCategory = new Category("orange", null, new HashSet());

			// 西红柿类别
			Category tomatoCategory = new Category("tomato", null, new HashSet());

			foodCategory.getChildCategories().add(fruitCategory);
			fruitCategory.setParentCategory(foodCategory);

			foodCategory.getChildCategories().add(vegetableCategory);
			vegetableCategory.setParentCategory(foodCategory);

			fruitCategory.getChildCategories().add(appleCategory);
			appleCategory.setParentCategory(fruitCategory);

			fruitCategory.getChildCategories().add(orangeCategory);
			orangeCategory.setParentCategory(fruitCategory);

			vegetableCategory.getChildCategories().add(tomatoCategory);
			tomatoCategory.setParentCategory(vegetableCategory);

			session.save(foodCategory); // 级联保存所有的关联对象
			tx.commit();
		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// saveCustomerAndOrderWithCascade();
		// saveCategoryWithCascade();
		deleteCategoryWithCascade();
	}

}
