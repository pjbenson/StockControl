package com.spring.daomanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoleDAO;
import com.spring.model.Role;

@Service
@Transactional
public class RoleManagerImpl implements RoleManager {
	
	@Autowired
	private RoleDAO roleDAO;
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

}
