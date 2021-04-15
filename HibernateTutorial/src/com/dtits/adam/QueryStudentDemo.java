package com.dtits.adam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Student;

public class QueryStudentDemo {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student").getResultList();
			students.forEach(System.out::println);
			
			students = session.createQuery("from Student s WHERE s.lastName='Doe'").getResultList();
			students.forEach(System.out::println);
			
			students = session.createQuery("from Student s WHERE s.lastName='Doe' OR s.firstName='May'").getResultList();
			students.forEach(System.out::println);
			
			students = session.createQuery("from Student s WHERE s.email LIKE '%gmail.com'").getResultList();
			students.forEach(System.out::println);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
}
