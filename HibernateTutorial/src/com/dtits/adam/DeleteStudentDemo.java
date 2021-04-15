package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int studentId = 5;
		
		try {
			session.beginTransaction();
		
			Student student = session.get(Student.class, studentId);
			
			session.delete(student);
			
			session.createQuery("DELETE from Student WHERE id = 2");

			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
}
