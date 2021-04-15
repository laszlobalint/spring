package com.luv2code.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.luv2code.springdemo.*.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.*.*.*get*(..))")
	public void getters() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.*.*.set*(..))")
	public void setters() {}
	
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	public void forDaoPackageFiltered() {}
}
