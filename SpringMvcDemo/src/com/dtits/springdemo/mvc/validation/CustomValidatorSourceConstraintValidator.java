package com.dtits.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatorSourceConstraintValidator implements ConstraintValidator<CustomValidatorSource, String> {
	
	private String[] customPrefixes;

	@Override
	public void initialize(CustomValidatorSource constraintAnnotation) {
		customPrefixes = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;
		
		if (value != null) {
			for (String prefix : customPrefixes) {
				result = value.startsWith(prefix);
				if (result)
					break;
			}
		} else {
			result = true;
		}
		
		return result;
	}
}