package com.sap.calcacademy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class InputParser {
	/**
	 * 
	 * @param input string input denoting the calculation
	 * @return a list with tokens that can be either doubles or Operation
	 * @throws InputMismatchException on wrong input
	 */
	public List<Object> parse(String input) throws IllegalArgumentException {
		ArrayList<Object> result = new ArrayList<>();
		String trimmedInput = input.replaceAll("\\s+","");
		StringBuilder sb = new StringBuilder();
		double sign = 1;
		for(char c: trimmedInput.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			} else {
				if (sb.length() != 0) {
					Double value = Double.valueOf(sb.toString());
					if (result.size() == 0) {
						value = sign*value; 
					}
					result.add(value);
					sb.setLength(0);
					switch (c) {
						case '+': 
							result.add(new AddOperation());
						break;
						default:
							throw new InputMismatchException();
					}
				} else {
					if (c != '+' && c != '-')
						throw new InputMismatchException();
					sign = c == '-' ? -1 : 1; 
				}
			}
		}
		if (sb.length() != 0) {
			result.add(Double.valueOf(sb.toString()));
		}
		return result;
	}

}
