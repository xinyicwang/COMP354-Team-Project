/*
 * Mean Absolute Deviation
 * Team J - COMP 354
 * Concordia University 
 * 
 * Version: Iteration II
 *
 * Due: August 10th 2020
 * 
 * Copyright notice
 */

package function;

/**
 * Class for calculating the Mean Absolute Deviation.
 * Has a function that calculates the absolute value of a number, 
 * and a function that calculates the sum of an array.
 * @version 31 July 2020
 * @author Wing-Fei Jason Tiu 40048495
 */

public class Mean {
	
	/*Implement this class by calling Mean.mad(array, array.length)*/

	/**
	* Function that calculates the absolute value of a number
     	* @param num: a number of type double
     	* @return the absolute value of number n
	*/
	
	private static double abs(double num)
	{
		 return (num <0) ? -num : num;
	}
	
	/**
	 * function that calculates the sum of an array consisting of doubles
	 * @param arr: array of doubles
	 * @return sum of the doubles inside the array
	 */
		
	private static double sum(double arr[])
	{
		double sum = 0;
        	for(int i = 0; i < arr.length; i++) {
            		sum += arr[i];
        	}
       		return sum;
	}
	
	/**
    	* Function that calculates the mean absolute deviation of an array of numbers
     	* @param arr: array of doubles
     	* @return the mean absolute deviation of the array
     	*/
		
	public static double mad(double arr[])
	{
		 
	     double mean = sum(arr) / arr.length;
	     
	     double abdiff = 0;
	     
	     /*Iterates through the array arr[], finds the absolute value at the index i and subtract the mean value from it.*/
	     
	     for(int i = 0; i < arr.length; i++) {
	            abdiff += abs((arr[i] - mean)) ;
	        }
	     
	     abdiff = (abdiff / arr.length);
	        
	     return abdiff;
		
	}

	
}
