package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Instructor;
import com.dtits.adam.entity.InstructorDetail;

public class DeleteDemo {
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			if (instructor != null)
				session.delete(instructor);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
}
