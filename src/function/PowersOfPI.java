package function;

public class PowersOfPI {

	 static final double EPSILON = 0.000000001;

		/**
		 * Function that calculates pi^x
		 * @param exp: exponent
		 * @return pi raised to the power of exp
		 */
		public static double powersOfPi(double exp)
		{
			double protoPi = 0;
			double sign = 1;
			int limit = 100000000; /*It might be necessary to calculate a stopping point from a given episolon*/

			for (int i = 1; i < limit; i+=2)
			{
				 protoPi += sign/i;
				 sign = -sign;
			}
			protoPi *=4;

			double pi = protoPi;

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


			// checks if the exponent is not an integer
			// if not, multiplies by 10 until it is, resulting in a fraction of
			// exp/nthRoot being the new exponent
			while (exp%1 != 0)
			{
				exp *= 10;
				nthRoot *= 10;
			}
			/* Leads to errors when dealing with powers of numbers with a lot of decimal places (pi^pi for example)*/
			
			base = root(base, nthRoot);

			double powerResult = 1;
			long newExp = (long) exp;

			powerResult = quickPower(base, newExp);
			return isNegative ? 1/powerResult : powerResult;
		}


		/**
		 * Finds the nth root by approximation
		 * @param base: number to approximate
		 * @param nthRoot: number of times the root needs to be multiplied by itself
		 * to result the base
		 * @return the nth root of the base
		 */
		private static double root(double base, long nthRoot)
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
		    	baseApproximation *= quickPower(root, nthRoot);

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
		                                        double base, long nthRoot)
		{
		    double estimatedRoot = 1;
		    long count = 0;

		    while (upperRoot - lowerRoot > EPSILON || count < 100000)
		    {
		        double middleBaseApproximation = 1;
		        double middleRoot = (upperRoot + lowerRoot)/2;

		        middleBaseApproximation = quickPower(middleRoot, nthRoot);

	            if (middleBaseApproximation > base)
	            {
	                upperRoot = middleRoot;
	            }
	            else
	            {
	                lowerRoot = middleRoot;
	            }

	            estimatedRoot = middleRoot;
	            count++;
		    }

		    return estimatedRoot;
		}
		
		/**
		 * Calculated the power in O(logn) time
		 * Adapted code from: https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
		 * @param base: base of the power
		 * @param exp: exponent 
		 * @return the power of base to the exponent
		 */
		private static double quickPower(double base, long exp) 
	    { 
	        double temp; 
	        if( exp == 0) 
	        {
	            return 1; 
	        }
	        temp = quickPower(base, exp/2);  
	          
	        if (exp%2 == 0) 
	        {
	            return temp*temp; 
	        }
	        else
	        { 
	            return base * temp * temp; 
	        } 
	    }  


}
