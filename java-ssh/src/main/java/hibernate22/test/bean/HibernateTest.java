package hibernate22.test.bean;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration().configure();

			sessionFactory = config.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public void findAllCustomers(PrintStream out) throws Exception {
		// Ask for a session using the JDBC information we've configured
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List customers = session.createQuery("from Customer as c order by c.name asc").list();
			for (Iterator it = customers.iterator(); it.hasNext();) {
				printCustomer(out, (Customer) it.next());
			}

			// We're done; make our changes permanent
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				// Something went wrong; discard all partial changes
				tx.rollback();
			}
			throw e;
		} finally {
			// No matter what, close the session
			session.close();
		}
	}

	public static void saveCustomer(Customer customer) throws Exception {

		// Ask for a session using the JDBC information we've configured
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(customer);
			// We're done; make our changes permanent
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				// Something went wrong; discard all partial changes
				tx.rollback();
			}
			throw e;
		} finally {
			// No matter what, close the session
			session.close();
		}
	}

	public void loadAndUpdateCustomer(Long customer_id, String address) throws Exception {
		// Ask for a session using the JDBC information we've configured
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Customer c = (Customer) session.load(Customer.class, customer_id);

			c.setAddress(address);

			// We're done; make our changes permanent

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				// Something went wrong; discard all partial changes
				tx.rollback();
			}
			throw e;
		} finally {
			// No matter what, close the session
			session.close();
		}
	}

	@SuppressWarnings("rawtypes")
	public void deleteAllCustomers() throws Exception {
		// Ask for a session using the JDBC information we've configured
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Query query = session.createQuery("from Customer");

			List list = query.list();

			for (Iterator i = list.iterator(); i.hasNext();) {
				session.delete((Customer) i.next());
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				// Something went wrong; discard all partial changes
				tx.rollback();
			}
			throw e;
		} finally {
			// No matter what, close the session
			session.close();
		}
	}

	private void printCustomer(PrintStream out, Customer customer) throws Exception {

		byte[] buffer = customer.getImage();
		OutputStream fout = new FileOutputStream("photo_copy.gif");
		fout.write(buffer);
		fout.close();

		out.println("------以下是" + customer.getName() + "的个人信息------");
		out.println("ID: " + customer.getId());
		out.println("口令: " + customer.getPassword());
		out.println("E-Mail: " + customer.getEmail());
		out.println("电话: " + customer.getPhone());
		out.println("地址: " + customer.getAddress());
		String sex = customer.getSex() == 'M' ? "男" : "女";
		out.println("性别: " + sex);
		String marriedStatus = customer.isMarried() ? "已婚" : "未婚";
		out.println("婚姻状况: " + marriedStatus);
		out.println("生日: " + customer.getBirthday());
		out.println("注册时间: " + customer.getRegisteredTime());
		out.println("自我介绍: " + customer.getDescription());

	}

	public void test(PrintStream out) throws Exception {

		Customer customer = new Customer();

		customer.setName("zhangsan");
		customer.setEmail("zhangsan@yahoo.com");
		customer.setPassword("1234");
		customer.setPhone(1381234);
		customer.setAddress("Shanghai");
		customer.setSex('M');
		customer.setDescription("I am very honest.");

		InputStream in = this.getClass().getResourceAsStream("photo.gif");

		byte[] buffer = new byte[in.available()];

		in.read(buffer);

		customer.setImage(buffer);

		customer.setBirthday(Date.valueOf("1980-05-06"));

		saveCustomer(customer);

		findAllCustomers(out);

		loadAndUpdateCustomer(customer.getId(), "Tianjin");

		findAllCustomers(out);

		deleteAllCustomers();
	}

	public static void main(String args[]) throws Exception {
		new HibernateTest().test(System.out);
		sessionFactory.close();
	}

}
