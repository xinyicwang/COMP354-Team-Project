/*
 * Exponentiation
 * Team J - COMP 354
 * Concordia University 
 * 
 * Version: Iteration II
 *
 * Due: August 10th 2020
 * 
 * Copyright notice
 * Consulted source:
 * https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 */

package function;

import Exceptions.*;
import gui.TwoVariableEquation;

/**
 * Class that calculates the power function (x^y)
 * Utilizes the bisection method to estimate the root for decimal exponents
 * @version 02 August 2020
 * @author Francis Truong 40087705
 */
public class Exponentiation implements TwoVariableEquation {

	/*Implement this class by calling calculatePower(double base, double exp)*/
	
	/**
	* Function that calculates the exponential given a base number and a power number (adjusting for rational numbers)
	* @param base: base number
	* @param exp: exponent number
	* @return exponentiation of base number to the power of exponent number
	*/
	public static double calculatePower(double base, double exp) throws InvalidInputException {
    	
    	double result = 1;
    	char sign = 'p'; 	
    	long nthRoot = 1;
    	double wholeNumber = exp;
    	int counter = 0;
    	boolean expOdd = false;
    	
    	while (wholeNumber % 1 != 0) {
    		counter++;
    		wholeNumber *= 10;
    	}
    	
    	if (wholeNumber < 0) {
    		wholeNumber *= -1;
    	}
    	
    	if (wholeNumber % 10 == 1 || wholeNumber % 10 == 3 || wholeNumber % 10 == 5 || wholeNumber % 10 == 7 || wholeNumber % 10 == 9) {
    		expOdd = true;
    	}
    	
    	if (exp < 0) {
    		if (base == 0) {
    			throw new Exceptions.InvalidInputException("Invalid input: 0 cannot be raised to a negative exponent.");
    		}
    		exp *= -1;
    		sign = 'n';
    	}
    	
    	if (base < 0 && sign == 'n') {
    		if (counter > 0 && expOdd) {
    			throw new Exceptions.InvalidInputException("Invalid input: negative base cannot have an odd decimal exponent.");
    		}
    	}
    	    	    	
    	if (base == 0) {
    		return base;
    	}
    		
    	while (exp % 1 != 0) {
    		exp *= 10;
    		nthRoot *= 10;
    	}
    	
    	double newBase = findRoot(base, nthRoot);
    	    	
    	result = calculateIntegerPower(newBase, (long) exp);
    	
    	if (sign == 'p') {
    		return result;
    	}
    	else {
    		return ((double) 1 / result);
    	}
    }
    
	/**
	* Function that calculates the exponential given a base number and an integer power number, using recursion
	* Inspired by https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
	* @param base: base number
	* @param exp: exponent number
	* @return exponentiation of base number to the power of exponent number
	*/
	public static double calculateIntegerPower(double base, long exp) {
    	
    	double result; 
        
    	if (exp == 0) 
        {
            return 1; 
        }
        
        result = calculateIntegerPower(base, exp / 2);  
          
        if (exp % 2 == 0) 
        {
            return result * result; 
        }
        else
        { 
            return base * result * result; 
        } 
 
    }
 
	/**
	* Function that estimates the nth root
	* @param base: number to estimate
	* @param nthRoot: number of times needed to multiply to find the base
	* @return the nth root of the base
	*/
	private static double findRoot(double base, long nthRoot) {
    	   	
    	if (nthRoot == 1) {
    		return base;
    	}
    	
    	double upper = 1;
    	double lower = 0;
    	double baseEstimate = 1;
    	
    	for (double root = 1; baseEstimate < base; root++) {
    		baseEstimate *= calculateIntegerPower(root, nthRoot);

    		if (base == baseEstimate) {
    			return root;
    		}
    		else { 
    			upper = root;
    		}
    	}
    	
    	lower = upper - 1;
    	
    	return estimateRoot(upper, lower, base, nthRoot);
    	
    }
    
	/**
	* Function that estimates the root, using the bisection method
	* @param upper: upper bound of the set containing the real root
	* @param lower: lower bound of the set containing the real root
	* @param base: number of the nth root
	* @param nthRoot: number of times needed to multiply to find the base
	* @return a middle estimate of the root between upper and lower numbers
	*/
	private static double estimateRoot(double upper, double lower, double base, long nthRoot) {
    	
    	long iteration = 0;
    	double epsilon = 0.0000000001;
    	double middleEstimate;
    	double middle = 1;
    	
    	double absDifference = upper - lower;
    	if (absDifference < 0) {
    		absDifference *= -1;
    	}
    	
    	while (absDifference > epsilon) {

    		middle = (upper+lower)/2;
    		middleEstimate = calculateIntegerPower(middle, nthRoot);
    		
    		if (middleEstimate > base) {
    			upper = middle;
    		}
    		else {
    			lower = middle;
    		}
    		
    		absDifference = upper - lower;
    		if (absDifference < 0) {
        		absDifference *= -1;
    		}
    		
    		iteration++;
    		if (iteration == 1000) {
    			break;
    		}
    	}
    	
    	return middle;
    }

	@Override
	public double calculate(double x, double y) throws InvalidInputException {
		return Exponentiation.calculatePower(x,y);
	}
    	
} 
