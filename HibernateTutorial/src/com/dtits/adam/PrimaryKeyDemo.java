package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		org.hibernate.SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student1 = new Student("Rob", "Fog", "robfog@gmail.com");
			Student student2 = new Student("May", "Flower", "flower@gmail.com");
			Student student3 = new Student("Bonita", "Fragile", "bonita@gmail.com");
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}

}
