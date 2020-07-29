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

import Exceptions.InvalidInputException;
import function.PowersOfPI;
import function.EPower;
import function.Exponentiation;
import function.StandardDeviation;
import function.Mean;


public class CalculatorApp {

	public static void main(String[] args) throws InvalidInputException {
				
		//Test x^y
		System.out.println("==========Testing x^y==========");
		System.out.println("3^4.5 = " + Exponentiation.power(3, 4.5));
		System.out.println("-25^-2 = " + Exponentiation.power(-25,-2));		
		System.out.println("-20.5^5 = " + Exponentiation.power(-20.5,5));
		System.out.println("5^2.6 = " + Exponentiation.power(5,2.6));
		System.out.println("\n");
		System.out.println(Math.pow(Math.E,100));

		// Test e^x
		System.out.println("==========Testing e^x==========");
		System.out.println("Testing with a small integer number: e^20 = " + EPower.ePower(20));
		System.out.println("Testing with a large integer number: e^100 = " + EPower.ePower(100));
		System.out.println("Testing with decimal number: e^0.5 = " + EPower.ePower(0.5));
		System.out.println("Testing with a negative integer number: e^(-2.5) = " + EPower.ePower(-2.5));
		System.out.println("\n");
		
		
		//Test pi^x
		System.out.println("==========Testing pi^x==========");
		System.out.println("pi^1 = " + PowersOfPI.powersOfPi(1));
		System.out.println("pi^(2.1) = " + PowersOfPI.powersOfPi(2.1));
		System.out.println("pi^(-1) = " + PowersOfPI.powersOfPi(-1));
		System.out.println("\n");

		
		//Test Standard Deviation & MAD
		System.out.println("==========Testing Standard Deviation and Mean==========");
		List<Double> nums = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		// prompt for user input
		do {
			System.out.println("Current input is " + nums);
			System.out.println("Add more? (y/n)");
			if(sc.next().startsWith("y")) {
				System.out.println("Enter: ");
				nums.add(sc.nextDouble());
			}
			else {
				break;
			}
		} while(true);

		sc.close();
		System.out.println("List is " + nums);

		if (nums.size() != 0) {
			// map user input into an array of doubles
			double[] doubles = new double[nums.size()];
			for(int i = 0; i < doubles.length; i++) {
				doubles[i] = nums.get(i);
	   	}
			int n = doubles.length;
				
			System.out.println("The standard deviation of " + n + " numbers is "
					+ StandardDeviation.standardDeviation(doubles, n));
			System.out.println("The mean absolute deviation of the numbers is "
					+ Mean.mad(doubles, n));
		}
	}

}
