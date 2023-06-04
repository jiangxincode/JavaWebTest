package hibernatespring.test.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import hibernatespring.PersonBean;
import hibernatespring.test.dao.PersonDAO;

public class PersonDAOImpl extends HibernateDaoSupport implements PersonDAO {

	@Override
	public void createPerson(PersonBean person) {
		this.getHibernateTemplate().save(person);

	}

	@Override
	public PersonBean getPerson(int id) {
		PersonBean person = (PersonBean)this.getHibernateTemplate().get(PersonBean.class, id);
		return person;
	}

	@Override
	public List findPersonsByName(String name) {
		List list = this.getHibernateTemplate().find("from PersonBean as p where p.name like ?", "%" + name + "%");
		return list;
	}

	@Override
	public void deletePerson(int id) {
		PersonBean person = (PersonBean)this.getHibernateTemplate().get(PersonBean.class, id);
		this.getHibernateTemplate().delete(person);

	}

	@Override
	public void updatePerson(PersonBean person) {
		this.getHibernateTemplate().saveOrUpdate(person);

	}

}
