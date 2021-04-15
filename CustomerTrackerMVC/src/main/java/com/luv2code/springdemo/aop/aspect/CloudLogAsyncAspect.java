package com.luv2code.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {
	
	@Before("com.luv2code.springdemo.aop.aspect.AopExpressions.forDaoPackageFiltered()")
	public void writeToConsole() {
		System.out.println("\n========> Logging to Cloud in Async");
	}
}
