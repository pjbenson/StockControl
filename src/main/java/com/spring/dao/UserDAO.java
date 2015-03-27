package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDAO {

	public void insertUser(User user);
	
	public User checkLogin(String userName, String password);

	public List<User> findAllUsers();
	
	public User getUserById(int id);
	
	public void deleteUser(int id);

}
