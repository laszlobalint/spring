package com.dtits.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CustomValidatorSourceConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidatorSource {
	
	public String[] value() default {"HUN", "SER", "CRO"};
	
	public String message() default "must start with HUN, SER or CRO";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
;}
