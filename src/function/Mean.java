package function;

import java.util.List;

import gui.MultiVariableEquation;

public class Mean implements MultiVariableEquation {

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
     	* @param n: length of the array
     	* @return the mean absolute deviation of the array
     	*/
		
	public static double mad(double arr[], int n)
	{
		 
	     double mean = sum(arr) / (double) n;
	     
	     double abdiff = 0;
	     
	     for(int i = 0; i < n; i++) {
	            abdiff += abs((arr[i] - mean)) ;
	        }
	     
	     abdiff = (abdiff / (double) n);
	        
	     return abdiff;
		
	}

	@Override
	public double calculate(List<Double> x) {
		int size = x.size();
		double[] items = new double[size];
		for(int i = 0; i < x.size(); i ++) {
			items[i] = x.get(i);
		}
		return Mean.mad(items, size);
	}

	
}
