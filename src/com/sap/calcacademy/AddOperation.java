package com.sap.calcacademy;

public class AddOperation implements Operation {

	@Override
	public double execute(double operand1, double operand2) {
		return operand1 + operand2;
	}

	@Override
	public String toString() {
		return "+";
	}
}
