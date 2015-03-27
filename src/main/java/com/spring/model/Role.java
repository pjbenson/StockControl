package com.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role{
	@Id
	@Column(name = "id") 
	private Integer id;
	@Column(name = "role")
	private String role;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="user_roles", 
		joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
	)
	private Set<User> userRoles;
 
	public Set<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	}

	public Integer getId() {
		return this.id;
	}
 
	public void setId(Integer roleId) {
		this.id = roleId;
	}
 
	public String getRole() {
		return this.role;
	}
 
	public void setRole(String role) {
		this.role = role;
	}
 
}
