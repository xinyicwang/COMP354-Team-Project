package function;
public class Power2 {

	 static final double EPSILON = 0.000001;
	        
	/**
     	* Function that calculates pi^x
     	* @param exp: exponent
     	* @return pi raised to the power of exp
     	*/
	public static double powersOfPi(double exp)
	{
		double pi = 0;
		double sign = 1;
		int limit = 100000000;

		for (int i = 1; i < limit; i+=2)
		{
		   pi += sign/i;
		   sign = -sign;
		}
		pi *=4;

		return power(pi, exp);
	}
	
	/**
	* Function that calculates the power of a number raised to an exponent
	* @param base: base number
	* @param exp: exponent
	* @return the result of base multiplied by itself exp times
	*/
	private static double power(double base, double exp)
	{
		long nthRoot = 1;
		boolean isNegative = exp < 0;
			
		exp = isNegative ? exp*(-1) : exp;

		//checks if the exponent is not an integer
		//if not, multiplies by 10 until it is, resulting in a fraction of 
		//exp/nthRoot being the new exponent
		while (exp%1 != 0)
		{
			nthRoot *= 10;
			exp *= nthRoot;
		}

		base = root(base, nthRoot);
		double powerResult = 1;

		for (int i = 0; i < exp; i++)
		{
			powerResult *= base;
		}
					
		return isNegative ? 1/powerResult : powerResult;
	}
		
		
	/**
	* Finds the nth root by approximation
	* @param base: number to approximate
	* @param nthRoot: number of times the root needs to be multiplied by itself 
	* to result the base 
	* @return the nth root of the base
	*/
	private static double root(double base, double nthRoot)
	{
		if (nthRoot == 1)
		{
			return base;
		}
		    
		double upperRoot = 1;
		double lowerRoot = 0;
		    
		double baseApproximation = 1;
		    
		for (double root = 1; baseApproximation < base; root++)
		{
			for (int i = 0; i < nthRoot; i++)
	        	{
	        		baseApproximation *= root;
	            	}
	            
	            	if (baseApproximation == base)
	            	{
	                	return root;
	            	}
	            
	           	upperRoot = root;
		}
	        
	        lowerRoot = upperRoot - 1;
	        
		return bisectionMethod(upperRoot, lowerRoot, base, nthRoot);
	}
		

	/**
	* Approximates the root using Bisection Method
	* @param upperRoot: upper bound of the set of numbers that contain the real root
	* @param lowerRoot: lower bound of the set of numbers that contain the real root
	* @param base: number we are getting the nth root of
	* @param nthRoot: number of times the root needs to be multiplied by itself 
	* to result the base 
	* @return an approximation of the root
	*/
	private static double bisectionMethod(double upperRoot, double lowerRoot, 
		                                        double base, double nthRoot)
	{
		double estimatedRoot = 1;
		    
		while (upperRoot - lowerRoot > EPSILON)
		{
			double middleBaseApproximation = 1;
		        double middleRoot = (upperRoot + lowerRoot)/2;
		    
		        for (int i = 0; i < nthRoot; i++)
	            	{
	                	middleBaseApproximation  *= middleRoot;
	            	}
	            
	          	if (middleBaseApproximation > base)
	            	{
	                	upperRoot = middleRoot;
	            	}
	            	else
	            	{
	                	lowerRoot = middleRoot;
	            	}
	            
	            	estimatedRoot = middleRoot;
		}
		    
		    return estimatedRoot;
		}
	
}