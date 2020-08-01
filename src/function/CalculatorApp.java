package function;


public class CalculatorApp 
{
    static final double EPSILON = 0.001;

    public static void main(String[] args)
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
        
        double result = power(pi, 2);
        System.out.println(power(10,100));
    }
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
	public static double power(double base, double exp)
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
		// 1th root of any number is the same number
		if(nthRoot == 1)
		{
			return base;
		}
		
		// Random initial guess x0
		double x0 = Math.random() % 10;
		
		// Defines accuracy of calculation
		double epsilon = 0.001;
	
		// Used to check when desired precision is achieved
		double deltaX = Integer.MAX_VALUE;
		
		// current value of xK
		double currentX = 0.0;
		
		// Repeat calculation until x0 converges to nth root
		while(deltaX > epsilon) {
			// Calculate pow(x0, root - 1)
			double pow = x0;
			for(int i = 0 ; i < nthRoot - 2 ; ++i) {
				pow *= x0;
			}
			
			currentX = ((nthRoot - 1.0) * x0 + base / pow) / nthRoot;
			double temp_deltaX = currentX - x0;
			
			// Absolute value of delta X
			if(temp_deltaX < 0) {
				temp_deltaX = -temp_deltaX;
			}
			
			deltaX = temp_deltaX;
			
			x0 = currentX;
		}
		
		return currentX;
	}

}