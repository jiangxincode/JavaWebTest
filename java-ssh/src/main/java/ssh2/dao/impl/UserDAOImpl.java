package ssh2.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh2.bean.User;
import ssh2.dao.UserDAO;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		String hql = "from User user order by user.id desc";

		return (List<User>) this.getHibernateTemplate().find(hql);
	}

	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	public User findUserById(Integer id) {
		User user = (User) this.getHibernateTemplate().get(User.class, id);

		return user;
	}

}
