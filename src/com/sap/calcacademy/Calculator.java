package com.sap.calcacademy;

import java.util.List;

public class Calculator {

	public Double calculate(String input) throws IllegalArgumentException {
		InputParser parser = new InputParser();
		List<Object> tokens = parser.parse(input);
		return ((Operation)tokens.get(1)).execute((Double)tokens.get(0), (Double)tokens.get(2));
	}
	
}
