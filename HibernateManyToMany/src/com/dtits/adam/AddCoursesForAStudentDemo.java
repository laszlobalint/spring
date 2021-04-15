package com.dtits.adam;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dtits.adam.entity.Course;
import com.dtits.adam.entity.Instructor;
import com.dtits.adam.entity.InstructorDetail;
import com.dtits.adam.entity.Review;
import com.dtits.adam.entity.Student;

public class AddCoursesForAStudentDemo {
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
			
			int id = 1;
			Student student = session.get(Student.class, id);
			
			System.out.println(student);
			student.getCourses().forEach(System.out::println);
				
			Course course1 = new Course("Rubik's Cube - How to Speed Cube");
			Course course2 = new Course("Learn Hibernate - Cool Stuff");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
