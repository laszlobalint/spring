package com.luv2code.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspect {
	
	@Before("com.luv2code.springdemo.aop.aspect.AopExpressions.forDaoPackageFiltered()")
	public void logToConsole() {
		System.out.println("\n========> API Analytics");
	}
}
