package com.dtits.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dtits.springdemo.mvc.validation.CustomValidatorSource;

public class Customer {
	private String firstName;
	
	@NotNull(message = "... is required")
	@Size(min = 2, message = "... is required")
	private String lastName;
	
	@NotNull(message = "... is required")
	@Min(value = 0, message="... must be greater or equal to zero")
	@Max(value = 10, message="... must be equal or less than ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message = "... only 5 chars or digits are allowed")
	private String postalCode;
	
	@CustomValidatorSource
	private String countryCode;
	
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
