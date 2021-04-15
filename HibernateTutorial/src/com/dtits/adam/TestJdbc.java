package com.dtits.adam;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String USERNAME = "hbstudent";
		String PASSWORD = "hbstudent";
		
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
