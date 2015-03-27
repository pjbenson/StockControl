package com.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	@Transactional
	public void insertUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> findAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession(); 
		User user = (User) session.get(User.class, new Integer(id));
		return user;
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession(); 
		User user = (User) session.load(User.class, new Integer(id));
		if(null != user){
            session.delete(user);
        }
	}

	@Override
	@Transactional
	public User checkLogin(String userName, String password) {
		List<User> userList = findAllUsers();
		User userToReturn = null;
		for(User user: userList){
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
				userToReturn = user;
		}
		return userToReturn;
	}

}
