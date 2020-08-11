package com.shopingCart.mathUtills;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtillsTest {

	MathUtills mathUtills;

	@BeforeEach
	void init() {
		mathUtills = new MathUtills();
	}

	@AfterEach
	void cleanUp() {
		System.out.println("clean all ");
	}

	@BeforeAll
	public void print() {
		System.out.println("begain ");
	}

	@Test
	void testAdd() {

		assertEquals(2, mathUtills.add(1, 1), "should add two numbers");

	}

	@Test
	void testCircleRadius() {

		assertEquals(Math.PI * 10 * 10, mathUtills.computeCircleArea(10), "area of circle");
if(1==1) {
	fail();
}
	}

	@Test
	void testdevide() {

	}
}
