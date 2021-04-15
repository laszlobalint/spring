package com.dtits.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtits.springsecurity.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleByName(String roleName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Role> theQuery = currentSession.createQuery("FROM Role WHERE name=:name", Role.class);
		theQuery.setParameter("name", roleName);
		
		Role role = null;
		
		try {
			role = theQuery.getSingleResult();
			
		} catch (Exception e) {
			role = null;
		}
		
		return role;
	}
}
