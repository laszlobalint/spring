package com.firstspring.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "person")
@Component
public class PersonModel {
	
	@Value("${spring.profiles.active}")
	private String selectedProfile;
	
	@Value("${msg}")
	private String message;
	
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String phoneNumber;
	
	public PersonModel() {
	}
	
	public PersonModel(String firstName) {
		super();
		this.firstName = firstName;
	}

	public PersonModel(String firstName, String lastName, int age, String address, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSelectedProfile() {
		return selectedProfile;
	}

	public void setSelectedProfile(String selectedProfile) {
		this.selectedProfile = selectedProfile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PersonModel [selectedProfile=" + selectedProfile + ", message=" + message + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ "]";
	}
}
