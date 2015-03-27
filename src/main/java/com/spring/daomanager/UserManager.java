package com.spring.daomanager;

import java.util.List;

import com.spring.model.User;

public interface UserManager {

	void insertUser(User user);

	List<User> findAllUsers();

	public User getUserById(int id);

	public void deleteUser(int id);
	
	public User checkLogin(String userName, String password);

}
