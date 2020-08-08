package com.shopingCart.mathUtills;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtillsTest {

	@Test
	void testAdd() {
		MathUtills mathUtills = new MathUtills();

		assertEquals(2, mathUtills.add(1, 1), "should add two numbers");

	}

	
	@Test
	void testCircleRadius() {
		MathUtills mathUtills = new MathUtills();

		assertEquals(Math.PI*10*10, mathUtills.computeCircleArea(10), "area of circle");

	}
	@Test
	void testdevide() {
		
		MathUtills mathUtills = new MathUtills();
		assertThrows(NullPointerException.class, ()->mathUtills.div(1, 0),"devide by 0");



	}
}
