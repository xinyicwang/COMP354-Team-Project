<<<<<<< HEAD
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

import java.util.*;

import Exceptions.InfinityException;
=======
import java.util.*;

>>>>>>> origin/standard-deviation
import function.PowersOfPI;
import function.EPower;
import function.Exponentiation;
import function.StandardDeviation;
import function.Mean;

<<<<<<< HEAD
/**
 * Tests functions with given input to showcase the results
 * @version 24 July 2020
 * @author Briana Toia 40097889
 */
public class CalculatorApp {

	/**
	 * Displays results of our tests 
	 * @param args
	 * @throws InfinityException
	 */
	public static void main(String[] args) throws InfinityException {
=======

public class CalculatorApp {

	public static void main(String[] args) {
>>>>>>> origin/standard-deviation
		//Test x^y
		System.out.println("==========Testing x^y==========");
		System.out.println("3^4 = " + Exponentiation.powerInt(3,4.5));
		System.out.println("25^3 = " + Exponentiation.powerInt(25,3));
		System.out.println("-2^5 = " + Exponentiation.powerInt(-2,5));
		System.out.println("2^-2 = " + Exponentiation.powerInt(2,-2.5));
		System.out.println("\n");
		System.out.println(Math.pow(Math.E,100));

		// Test e^x
		System.out.println("==========Testing e^x==========");
<<<<<<< HEAD
		System.out.println("Testing with a small integer number: e^20 = " 
								+ EPower.ePower(20));
		System.out.println("Testing with a large integer number: e^100 = "
								+ EPower.ePower(100));
		System.out.println("Testing with decimal number: e^0.5 = " 
								+ EPower.ePower(0.5));
		System.out.println("Testing with a negative integer number: e^(-2.5) = " 
								+ EPower.ePower(-2.5));
=======
		System.out.println("Testing with a small integer number: e^20 = " + EPower.ePower(20));
		System.out.println("Testing with a large integer number: e^100 = " + EPower.ePower(100));
		System.out.println("Testing with decimal number: e^0.5 = " + EPower.ePower(0.5));
		System.out.println("Testing with a negative integer number: e^(-2.5) = " + EPower.ePower(-2.5));
>>>>>>> origin/standard-deviation
		System.out.println("\n");
		
		
		//Test pi^x
		System.out.println("==========Testing pi^x==========");
<<<<<<< HEAD
		System.out.println("pi^1 = " + PowersOfPI.calculatePowersOfPi(1));
		System.out.println("pi^(2.1) = " + PowersOfPI.calculatePowersOfPi(2.1));
		System.out.println("pi^(-1) = " + PowersOfPI.calculatePowersOfPi(-1));
=======
		System.out.println("pi^1 = " + PowersOfPI.powersOfPi(1));
		System.out.println("pi^(2.1) = " + PowersOfPI.powersOfPi(2.1));
		System.out.println("pi^(-1) = " + PowersOfPI.powersOfPi(-1));
>>>>>>> origin/standard-deviation
		System.out.println("\n");

		
		//Test Standard Deviation & MAD
		System.out.println("==========Testing Standard Deviation and Mean==========");
<<<<<<< HEAD
		
=======
>>>>>>> origin/standard-deviation
		List<Double> nums = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		// prompt for user input
		do {
			System.out.println("Current input is " + nums);
			System.out.println("Add more? (y/n)");
<<<<<<< HEAD
			
			if (sc.next().startsWith("y")) {
=======
			if(sc.next().startsWith("y")) {
>>>>>>> origin/standard-deviation
				System.out.println("Enter: ");
				nums.add(sc.nextDouble());
			}
			else {
				break;
			}
<<<<<<< HEAD
		} while (true);
=======
		} while(true);
>>>>>>> origin/standard-deviation

		sc.close();
		System.out.println("List is " + nums);

		if (nums.size() != 0) {
			// map user input into an array of doubles
			double[] doubles = new double[nums.size()];
<<<<<<< HEAD
			int n;
			
			for(int i = 0; i < doubles.length; i++) {
				doubles[i] = nums.get(i);
			}
			
			n = doubles.length;
=======
			for(int i = 0; i < doubles.length; i++) {
				doubles[i] = nums.get(i);
	   	}
			int n = doubles.length;
>>>>>>> origin/standard-deviation
				
			System.out.println("The standard deviation of " + n + " numbers is "
					+ StandardDeviation.standardDeviation(doubles, n));
			System.out.println("The mean absolute deviation of the numbers is "
					+ Mean.mad(doubles, n));
		}
	}

}
