/*
 * TestCalculator
 * Team J - COMP 354
 * Concordia University 
 * 
 * Version: Iteration II
 *
 * Due: August 10th 2020
 * 
 * Copyright notice
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.SinCalculator;

/**
 * Class to calculate the sin of a variable
 * 
 * @author Jenny Velicogna
 * 
 * @version 1.0
 *
 */
class SinTestsCalculatorApp {

	private static final double  EPSILON = 0.0000001;

	@Test
	/**
	 * Tests PI in SinCalculator 
	 * @throws InfinityException
	 */
	void test1() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.PI, scalc.getPI(), EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(0)
	 * @throws InfinityException
	 */
	void test2() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(0),scalc.calculate(0),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(1)
	 * @throws InfinityException
	 */
	void test3() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(1),scalc.calculate(1),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(-1)
	 * @throws InfinityException
	 */
	void test4() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(-1),scalc.calculate(-1),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(-5)
	 * @throws InfinityException
	 */
	void test5() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(-5),scalc.calculate(-5),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(5)
	 * @throws InfinityException
	 */
	void test6() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(5),scalc.calculate(5),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(PI)
	 * @throws InfinityException
	 */
	void test7() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(Math.PI),scalc.calculate(scalc.getPI()),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(PI * -1)
	 * @throws InfinityException
	 */
	void test8() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(Math.PI * -1),scalc.calculate(scalc.getPI() * -1),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(PI * -2)
	 * @throws InfinityException
	 */
	void test9() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(Math.PI * -2),scalc.calculate(scalc.getPI() * -2),EPSILON);
	}
	
	@Test
	/**
	 * Tests sin(PI * 2)
	 * @throws InfinityException
	 */
	void test10() {
		SinCalculator scalc = new SinCalculator();
		assertEquals(Math.sin(Math.PI * 2),scalc.calculate(scalc.getPI() * 2),EPSILON);
	}

}
