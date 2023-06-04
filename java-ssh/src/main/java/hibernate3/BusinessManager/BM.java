package hibernate3.BusinessManager;

import org.hibernate.HibernateException;

import hibernate3.persistence.StudentDAO;

public class BM {
	public static void main(String[] args) throws HibernateException {

		StudentDAO.mdfChoice();

	}

}
