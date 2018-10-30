package com.sap.calcacademy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ParsingTest {

	@Test
	public void basicTest() {
		InputParser parser = new InputParser();
		List<Object> tokens = parser.parse("2+2");
		System.out.println(tokens);
		assertEquals(3, tokens.size());
		assertEquals(tokens.get(0), Double.valueOf(2));
		assertEquals(tokens.get(1).getClass().getName(), AddOperation.class.getName());
		assertEquals(tokens.get(2), Double.valueOf(2));
	}
	
	@Test
	public void whitespaceTest() {
		InputParser parser = new InputParser();
		List<Object> tokens = parser.parse(" 2+ 2");
		System.out.println(tokens);
		assertEquals(3, tokens.size());
		assertEquals(tokens.get(0), Double.valueOf(2));
		assertEquals(tokens.get(1).getClass().getName(), AddOperation.class.getName());
		assertEquals(tokens.get(2), Double.valueOf(2));
	}
}
