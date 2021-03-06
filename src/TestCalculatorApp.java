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

import Exceptions.InfinityException;
import Exceptions.InvalidInputException;
import function.PowersOfPI;
import function.EPower;
import function.Exponentiation;
import function.StandardDeviation;
import function.Mean;

/**
 * Tests functions with powers with given bases & exponents
 * Compares with Java Math function
 * @version 24 July 2020
 * @author Briana Toia 40097889
 */
class TestCalculatorApp {

	final double DELTA = 0.0000001; //accuracy 
	
	/**
	 * function that returns average of the values in the array.
	 * @param arr
	 * @return average value as a double
	 */
   	private static double mean(double arr[]) {
		double sum = 0;

		for(int i = 0; i < arr.length; i++) {
		    sum += arr[i];
		}

		double mean = (double)sum / (double)arr.length;

		return mean;
    	}
	
	/**
	 * Tests PI^0 
	 * @throws InfinityException
	 */
	@Test
	void test1PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, 0), calculator.calculatePowersOfPi(0), DELTA);
	}

	/**
	 * Tests PI^2.1
	 * @throws InfinityException
	 */
	@Test
	void test2PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, 2.1), calculator.calculatePowersOfPi(2.1), DELTA);
	}

	
	/**
	 * Tests PI^-1
	 * @throws InfinityException
	 */
	@Test
	void test3PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, -1), calculator.calculatePowersOfPi(-1), DELTA);
	}

	/**
	 * Tests PI^100
	 * @throws InfinityException
	 */
	@Test
	void test4PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, 100), calculator.calculatePowersOfPi(100), DELTA);
	}
	/**
	 * Tests e^0
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test1E() throws InfinityException, InvalidInputException {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, 0), calculator.ePower(0), DELTA);
	}

	/**
	 * Tests e^2.1
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test2E() throws InfinityException, InvalidInputException { 
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, 2.1), calculator.ePower(2.1), DELTA);
	}

	/**
	 * Tests e^-1
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test3E() throws InfinityException, InvalidInputException {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, -1), calculator.ePower(-1), DELTA);
	}

	/**
	 * Tests e^100
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test4E() throws InfinityException, InvalidInputException {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, 100), calculator.ePower(100), DELTA);
	}
	
	/**
	 * Tests 5^0
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test1XY() throws InvalidInputException {
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(5, 0), calculator.calculatePower(5,0), DELTA);
	}

	/**
	 * Tests 3^2.1
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test2XY() throws InvalidInputException{
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(3, 2.1), calculator.calculatePower(3, 2.1), DELTA);
	}

	/**
	 * Tests 2.2^-1
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test3XY() throws InvalidInputException{
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(2.2, -1), calculator.calculatePower(2.2, -1), DELTA);
	}

	/**
	 * Tests 4^100
	 * @throws InfinityException
	 * @throws InvalidInputException
	 */
	@Test
	void test4XY() throws InvalidInputException{
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(4, 100), calculator.calculatePower(4, 100), DELTA);
	}
	

	/**
	*  Test valid input 
	*  comparing with the answer found using MAD calculator
	*/
	@Test
	void test1Mean() {
		double arr[] = {10.0, 15.0, 15.0, 17.0, 18.0, 21.0};

		//Used MAD calculator to verify the results.
		assertEquals(2.66667, Mean.mad(arr), 0.00001);
	}
    
	
	/**
	 *  Tests valid negative input 
	 *  comparing with the answer found using MAD calculator
	 */
	@Test
    	void test2Mean() {
		double arr[] = {10.0, -15.0, 17.0, -17.0, 18.0, 21.0};

		//Used MAD calculator to verify the results.
		assertEquals(14.44444, Mean.mad(arr), 0.00001);
    	}
    
	
	/**
	*  Tests one valid input 
	*  comparing with the answer found using MAD calculator
	*/
	@Test
	void test3Mean() {
		double arr[] = {10};

		double absSum = 0;

		for(int i = 0; i < arr.length; i++) {
		    absSum += absSum + Math.abs(arr[i] - mean(arr));
		}

		double res = absSum;

		assertEquals(res, Mean.mad(arr), 0.00001);
	    }

	
	/**
	*  Tests one valid negative input 
	*  comparing with the answer found using MAD calculator
	*/
	@Test
	void test4Mean() {
		double arr[] = {-21.5};

		double absSum = 0;

		for(int i = 0; i < arr.length; i++) {
		    absSum += absSum + Math.abs(arr[i] - mean(arr));
		}

		double res = absSum;

		assertEquals(res, Mean.mad(arr), 0.00001);
	    }

}
