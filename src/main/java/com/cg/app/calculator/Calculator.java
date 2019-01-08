package com.cg.app.calculator;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public Integer add(int numOne, int numTwo) {
		Logger logger = Logger.getLogger(Calculator.class.getName());
		int result = numOne + numTwo;
		logger.info("Addition Result: "+result);
		return result;
	}
}
