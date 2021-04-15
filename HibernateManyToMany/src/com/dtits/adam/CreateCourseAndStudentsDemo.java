package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Course;
import com.dtits.adam.entity.Instructor;
import com.dtits.adam.entity.InstructorDetail;
import com.dtits.adam.entity.Review;
import com.dtits.adam.entity.Student;

public class CreateCourseAndStudentsDemo {
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
			
			Course course = new Course("Pacman - How to Score One Million Points");
			session.save(course);
			
			Student marie = new Student("Marie", "Berry", "marry@gmail.com");
			Student john = new Student("John", "Doe", "doe@test.com");
			
			course.addStudent(marie);
			course.addStudent(john);
			
			session.save(marie);
			session.save(john);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
