package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Course;
import com.dtits.adam.entity.Instructor;
import com.dtits.adam.entity.InstructorDetail;

public class EagerLazyDemo {
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor: " + instructor);
			instructor.getCourses().forEach(System.out::println);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
