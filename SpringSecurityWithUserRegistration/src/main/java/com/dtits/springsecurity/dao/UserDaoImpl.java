package com.dtits.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtits.springsecurity.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = currentSession.createQuery("FROM User WHERE username=:username", User.class);
		theQuery.setParameter("username", username);
		
		User user = null;
		
		try {
			user = theQuery.getSingleResult();
			
		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theUser);
	}
}
