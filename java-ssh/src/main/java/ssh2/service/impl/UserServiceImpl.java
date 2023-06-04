package ssh2.service.impl;

import java.util.List;

import ssh2.bean.User;
import ssh2.dao.UserDAO;
import ssh2.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void save(User user) {
		this.userDao.saveUser(user); // 完成真正的业务逻辑
	}

	public List<User> findAll() {
		return this.userDao.findAllUsers();
	}

	public void delete(User user) {
		this.userDao.removeUser(user);
	}

	public void update(User user) {
		this.userDao.updateUser(user);
	}

	public User findById(Integer id) {
		return this.userDao.findUserById(id);
	}

}
