package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dtits.adam.entity.Course;
import com.dtits.adam.entity.Instructor;
import com.dtits.adam.entity.InstructorDetail;

public class FetchJoinDemo {
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
			
			Query<Instructor> query = session.createQuery(
					"SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id =: instructorId", 
					Instructor.class);
			query.setParameter("instructorId", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor: " + instructor);
			
			session.getTransaction().commit();
			
			session.close();
			
			instructor.getCourses().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
