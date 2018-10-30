package com.sap.calcacademy;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveTest {

	@Test
	public void test() throws Exception {
		RecursiveCalc calc = new RecursiveCalc();
		double result = calc.calculate("9/3/3");
		assertEquals(1, result, 0);
		result = calc.calculate("4*(5*(3*(4+1)))");
		assertEquals(300, result, 0);
		result = calc.calculate("(-4-1)*3");
		assertEquals(-15, result, 0);
		result = calc.calculate("(-4-1)*3+2*(1+1)");
		assertEquals(-11, result, 0);
		result = calc.calculate("-4*(3+1)+2");
		assertEquals(-14, result, 0);
		result = calc.calculate("2*(1+2)-4");
		assertEquals(2, result, 0);
	}

}
