package com.test.dao;

import java.util.List;

import com.test.bean.User;

public interface UserDAO {
	public void saveUser(User user);

	public List<User> findAllUsers();

	public void removeUser(User user);

	public void updateUser(User user);

	public User findUserById(Integer id);
}
