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

}
