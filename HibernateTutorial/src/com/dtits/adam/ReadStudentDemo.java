package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent = new Student("Raver", "Brave", "techno@gmail.com");
			session.beginTransaction();
			session.save(tempStudent);			
			Student retrievedStudent = session.get(Student.class, tempStudent.getId());
			System.out.println(tempStudent.getId());
			System.out.println(retrievedStudent);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
}
