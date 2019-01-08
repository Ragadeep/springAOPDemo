package com.cg.app.calculator;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorValidator {
	Logger logger = Logger.getLogger(CalculatorValidator.class.getName());
	
	@Before("execution(* com.cg.app.calculator.*.*(..))")
	private void log1() {
		logger.info("Before method");
	}
	
	@After("execution(* com.cg.app.calculator.*.*(..))")
	public void log2() {
		logger.info("After Mehod");
	}
	
	@Around("execution(* com.cg.app.calculator.*.*(..))")
	public Integer log3(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before - Logging the method");
		logger.info("function namr"+ pjp.getSignature()); 
		logger.info("parameters are:");
		Object retVal = pjp.proceed();
		logger.info("After - Logging the method");
		return (Integer) retVal;
	}
	
	@AfterReturning(pointcut = "execution(* com.cg.app.calculator.*.*(..))", returning = "retVal") 
	public void log4(Integer retVal) {
		logger.info(""+retVal);
	}
}
