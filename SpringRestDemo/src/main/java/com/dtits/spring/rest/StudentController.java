package com.dtits.spring.rest;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtits.spring.entity.Student;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> STUDENTS;
	
	@PostConstruct
	public void loadData() {
		STUDENTS = Arrays.asList(new Student("Brady", "Moore"), new Student("Mario", "Hombart"), new Student("Jane", "Addiction"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return STUDENTS;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		if (id >= STUDENTS.size() || id < 0 || STUDENTS.size() == 0 || STUDENTS == null) 
			throw new StudentNotFoundException("Student ID not found:" + id);
		
		return STUDENTS.get(id);
	}
}
