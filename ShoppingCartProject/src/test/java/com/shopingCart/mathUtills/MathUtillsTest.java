package com.shopingCart.mathUtills;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtillsTest {
	
	MathUtills mathUtills;
	
	
	@BeforeEach
	void init() {
		mathUtills=new MathUtills();
	}

	@Test
	void testAdd() {
	

		assertEquals(2, mathUtills.add(1, 1), "should add two numbers");
	

	}

	
	@Test
	void testCircleRadius() {

		assertEquals(Math.PI*10*10, mathUtills.computeCircleArea(10), "area of circle");

	}
	@Test
	void testdevide() {
		
		assertThrows(NullPointerException.class, ()->mathUtills.div(1, 0),"devide by 0");



	}
}
