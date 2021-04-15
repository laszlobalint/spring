package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeAppContext.xml");

		Coach theCoach = context.getBean("trackCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("trackCoach", Coach.class);
		
		boolean result = theCoach == alphaCoach;
		
		System.out.println(result);
		
		System.out.println("Memory location for theCoach: " + theCoach);
		
		System.out.println("Memory location for theCoach: " + alphaCoach);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
	}

}
