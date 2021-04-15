package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int studentId = 1;
		
		try {
			session.beginTransaction();
		
			Student student = session.get(Student.class, studentId);
			
			student.setFirstName("Test");
			
			session.createQuery("UPDATE Student SET email='foo@gmail.com'").executeUpdate();

			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
}
