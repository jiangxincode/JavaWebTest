package BusinessManager;

import org.hibernate.HibernateException;

import persistence.StudentDAO;

public class BM {
	public static void main(String[] args) throws HibernateException {

		StudentDAO.mdfChoice();

	}

}
