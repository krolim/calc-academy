package com.sap.calcacademy;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSimpleAdd() {
		Calculator calc = new Calculator();
		assertEquals(Double.valueOf(4), calc.calculate("2+2"));
	}
	
	@Test
	public void testNegativeAdd() {
		Calculator calc = new Calculator();
		assertEquals(Double.valueOf(1), calc.calculate("-2+3"));
	}
	
	@Test
	public void testMultipleAdd() {
		Calculator calc = new Calculator();
		assertEquals(Double.valueOf(7), calc.calculate("2+2+3"));
	}

}
