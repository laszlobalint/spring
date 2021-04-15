package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Course;
import com.dtits.adam.entity.Instructor;
import com.dtits.adam.entity.InstructorDetail;
import com.dtits.adam.entity.Review;
import com.dtits.adam.entity.Student;

public class DeleteACourse {
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			
			int id = 11;
			Course course = session.get(Course.class, id);
			
			if (course != null)
				session.delete(course);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
