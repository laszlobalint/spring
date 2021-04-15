package com.dtits.spring.json;

import java.io.File;

import com.dtits.spring.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	public static void main(String[] args) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println(student.toString());
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}