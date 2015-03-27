package com.spring.daomanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDAO;
import com.spring.model.User;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Override
	public User checkLogin(String userName, String password) {
		return userDAO.checkLogin(userName, password);
	}

}
