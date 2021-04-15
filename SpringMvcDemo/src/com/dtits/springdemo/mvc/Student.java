package com.dtits.springdemo.mvc;

import java.util.Map;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	private final Map<String, String> countries = Map.of(
		    "BR", "Brasil",
		    "FR", "France",
		    "DE", "Germany",
		    "IN", "India"
		);
	
	private final Map<String, String> languages = Map.of(
		    "Java", "Java",
		    "C++", "C++",
		    "Ruby", "Ruby",
		    "PHP", "PHP"
		);
	
	private final String[] systems = {"Mac OS, Windows, Linux"};
	
	public Student() {}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public Map<String, String> getLanguages() {
		return languages;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String[] getSystems() {
		return systems;
	}
}
