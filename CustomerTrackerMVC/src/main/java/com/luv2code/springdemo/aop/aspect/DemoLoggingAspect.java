package com.luv2code.springdemo.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Customer;

@Aspect
@Component
public class DemoLoggingAspect {
	
	private static Logger logger = Logger.getLogger(DemoLoggingAspect.class.getName());
		
	@Before("execution(public void com.luv2code.springdemo.aop.dao.TestDAO.logging(..))")
	public void beforeLoggingAdvice(JoinPoint joinPoint) {
		logger.info("\n========> Executing @Before advice");
		
		logger.info(joinPoint.getSignature());
		
		Object[] result = joinPoint.getArgs();

		logger.info(result.toString());
	}
	
	@AfterReturning(pointcut = "execution(* com.luv2code.springdemo.service.CustomerService.getCustomers(..))", returning = "customers")
	public List<Customer> afterReturningListCustomers(JoinPoint joinPoint, List<Customer> customers) {
		logger.info("=========> After Returning:\n");
		
		logger.info(joinPoint.getSignature().toShortString());
		
		customers.forEach(System.out::println);
		
		for (Object temp : customers) {
			if (temp instanceof Customer) {
				((Customer) temp).setFirstName(((Customer) temp).getFirstName().substring(0, 1).toUpperCase() + ((Customer) temp).getFirstName().substring(1).toLowerCase());
				((Customer) temp).setLastName(((Customer) temp).getLastName().substring(0, 1).toUpperCase() + ((Customer) temp).getLastName().substring(1).toLowerCase());
			}
		}
		
		return customers;
	}
	
	@After("execution(* com.luv2code.springdemo.service.CustomerService.getCustomers(..))")
	public void afterListCustomers(JoinPoint joinPoint) {
		logger.info("=========> After:\n");
		
		logger.info(joinPoint.getSignature().toShortString());
	}
	
	@AfterThrowing(pointcut = "execution(* com.luv2code.springdemo.service.CustomerService.getCustomers(..))", throwing = "exception")
	public void afterThrowingListCustomers(JoinPoint joinPoint, Throwable exception) {
		logger.info("=========> After Throwing:\n");
		
		logger.info(joinPoint.getSignature().toShortString());
		
		logger.info(exception);
	}
	
	@Around("execution(* com.luv2code.springdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("=========> Around execution:\n");
		
		logger.info(proceedingJoinPoint.getSignature().toShortString());
		
		long start = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		logger.info("DURATION OF METHOD IS " + (end - start) / 1000.0 + " seconds");
		
		return result;
	}
	
	@Around("execution(* com.luv2code.springdemo.service.*.getFortune(..))")
	public Object aroundWithExceptionHandlingGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("=========> Around execution:\n");
		
		logger.info(proceedingJoinPoint.getSignature().toShortString());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.warn(e.getStackTrace());
			result = "Major accident!";
		}
		
		long end = System.currentTimeMillis();
		
		logger.info("DURATION OF METHOD IS " + (end - start) / 1000.0 + " seconds");
		
		return result;
	}
	
	@Around("execution(* com.luv2code.springdemo.service.*.getFortune(..))")
	public Object aroundWithExceptionThrowingGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("=========> Around execution:\n");
		
		logger.info(proceedingJoinPoint.getSignature().toShortString());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.warn(e.getStackTrace());

			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		logger.info("DURATION OF METHOD IS " + (end - start) / 1000.0 + " seconds");
		
		return result;
	}
}
