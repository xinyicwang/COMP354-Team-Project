/*
 * PowersOfPi
 * Team J - COMP 354
 * Concordia University 
 * 
 * Version: Iteration II
 *
 * Due: August 10th 2020
 * 
 * Copyright notice
 * Written with the inspiration of two sources
 * https:stackoverflow.com/questions/20287513/can-anyone-make-heads-or-tales-of-this-spigot-algorithm-code-pitiny-c
 * https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 */

package function;

import Exceptions.*;
import gui.OneVariableEquation;

/**
 * Class for calculating the transcendental function PI^x.
 * Has a function that calculates pi using the Spigot algorithm
 * which calls a main power function.
 * This function then divides the work depending on the exponent 
 * @version 24 July 2020
 * @author Briana Toia 40097889
 */
public class PowersOfPI implements OneVariableEquation{

	/*Implement this class by calling calculatePowersOfPi(double exp)*/
	
	//limit of the difference between bounds to accept root approximation
	static final double EPSILON = 0.000000001;

	/**
	 * Function that calculates pi^x
	 * @param exp: exponent
	 * @return pi raised to the power of exp
	 * @throws InfinityException 
	 */
	public static double calculatePowersOfPi(double exp) throws InfinityException {
		
	//Calculates Pi based off the Spigot Algorithm
	//Adapted code from https:stackoverflow.com/questions/20287513/can-anyone-make-heads-or-tales-of-this-spigot-algorithm-code-pitiny-c
	//Math variables used to calculate pi 
	//therefore named a-i since it is difficult to give descriptive names
	int[] a = new int[55];
	int b = 0, c = 55, d = 0, e = 0, f = 10000, g = 0, h = 0, i = 0;
        String piDigits = "0.";
        double pi;
        
        while (c > 0) {
            d %= f;
            e  = d;
            b  = c - 1;
            g  = b * 2;

            while (g > 0) {
                g -= 1;
                i  = h != 0 ? a[b] : f / 5;
                d  = (d * b) + (f * i);
                a[b] = d % g;
                d /= g;
                b -= 1;
                g  = b * 2;
            }

            piDigits = piDigits.concat(Integer.toString(e + d / f));
            h  = 1;
            c -= 14;
        }
        pi = 10 * Double.parseDouble(piDigits);

	return calculatePower(pi, exp);
	}

	/**
	 * Function that calculates the power of a number raised to an exponent
	 * Organizes depending on whether an exponent is negative or a decimal
	 * @param base: base number
	 * @param exp: exponent
	 * @return the result of base multiplied by itself exp times
	 * @throws InfinityException 
	 */
	private static double calculatePower(double base, double exp) 
			throws InfinityException {

		long nthRoot = 1;
		boolean isNegative = exp < 0;
		double powerResult = 1;
		long newExp;
		int maxDecimalLength = 12; //helps reduce errors
		
		if (exp == 0)
		{
			return 1;
		}

		exp = isNegative ? exp * (-1) : exp;

		// checks if the exponent is not an integer
		// if not, multiplies by 10 until it is, resulting in a fraction of
		// exp/nthRoot being the new exponent
		// or until max decimal points allowed to reduce errors
		while (exp % 1 != 0 && maxDecimalLength != 0) {
			exp *= 10;
			nthRoot *= 10;
			maxDecimalLength--;
		}
		
		//fix for possible errors
		for (int i = 0; i < 12 - maxDecimalLength; i++)
		{
			if (Double.isNaN(exp % 10) || exp % 10 < 1 ) {
				exp /= 10;
				nthRoot /= 10;
			}
			else {
				break;
			}
		}

		base = calculateRoot(base, nthRoot);

		newExp = (long) exp;
		
		powerResult = calculateQuickPower(base, newExp);
		
		if (Double.isInfinite(powerResult)) {
			throw new Exceptions.InfinityException("Infinity");
		}
		
		return (isNegative ? 1 / powerResult : powerResult);
	}

	/**
	 * Finds the nth root by approximation
	 * Used for negative exponents 
	 * @param base: number to approximate
	 * @param nthRoot: number of times the root needs to be multiplied by itself
	 * to result the base
	 * @return the nth root of the base
	 */
	private static double calculateRoot(double base, long nthRoot) {
		
		double upperRoot = 1;
		double lowerRoot = 0;
		double baseApproximation = 1;
		
		if (nthRoot == 1) {
			return base;
		}

		for (double root = 1; baseApproximation < base; root++) {
			baseApproximation *= calculateQuickPower(root, nthRoot);

			if (baseApproximation == base) {
				return root;
			}

			upperRoot = root;
		}

		lowerRoot = upperRoot - 1;

		return approximateRoot(upperRoot, lowerRoot, base, nthRoot);
	}

	/**
	 * Approximates the root inspired by the Bisection Method
	 * iterates until the bounds have a slight difference between them or 
	 * when too many iterations have occurred. 
	 * @param upperRoot: upper bound of the set of numbers that contain the real root
	 * @param lowerRoot: lower bound of the set of numbers that contain the real root
	 * @param base: number we are getting the nth root of
	 * @param nthRoot: number of times the root needs to be multiplied by itself
	 * to result the base
	 * @return an approximation of the root
	 */
	private static double approximateRoot(double upperRoot, double lowerRoot,
			double base, long nthRoot) {
		
		double estimatedRoot = 1;
		long iterations = 0;

		while (upperRoot - lowerRoot > EPSILON || iterations < 100000) {
			double middleBaseApproximation = 1;
			double middleRoot = (upperRoot + lowerRoot) / 2;

			middleBaseApproximation = calculateQuickPower(middleRoot, nthRoot);

			if (middleBaseApproximation > base) {
				upperRoot = middleRoot;
			}
			else {
				lowerRoot = middleRoot;
			}

			estimatedRoot = middleRoot;
			iterations++;
		}

		return estimatedRoot;
	}

	/**
	 * Calculates the power in O(logn) time
	 * Only works with positive non-decimal exponents
	 * Adapted code from: https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
	 * @param base: base of the power
	 * @param exp: exponent 
	 * @return the power of base to the exponent
	 */
	private static double calculateQuickPower(double base, long exp) { 
		
		double temp; 
		
		if (exp == 0) {
			return 1; 
		}
		
		temp = calculateQuickPower(base, exp / 2);  

		if (exp % 2 == 0) {
			return temp * temp; 
		}
		else { 
			return base * temp * temp; 
		} 
	}

	@Override
	public double calculate(double x) throws InfinityException, InvalidInputException {
		return PowersOfPI.calculatePowersOfPi(x);
	}  
}
