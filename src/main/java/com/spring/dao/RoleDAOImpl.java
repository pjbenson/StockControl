package com.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Role;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
	
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public Role getRole(int id) {
		return (Role) sessionFactory.getCurrentSession().load(Role.class, id);
	}

}
