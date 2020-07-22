package function;

public class Exponentiation {

	
    /**
     * Function that calculates the exponential given a base number and an integer power number
     * @param base: base number
     * @param exp: exponent number
     * @return exponentiation of base number to the power of exponent number
     */
	
    public static double power (double base, double exp) {
    	double result = 1;
    	char sign = 'p'; 	
    	long nthRoot = 1;

    	if (exp < 0) {
    		exp *= -1;
    		sign = 'n';
    	}
    	
    	while (exp%1 != 0) {
    		exp *= 10;
    		nthRoot *= 10;
    	}
    	
    	double newBase = root(base, nthRoot);
    	    	
    	result = powerInt(newBase, (long) exp);
    	
    	if (sign == 'p')
    		return result;
    	else
    		return ((double)1/result);
    }
    
    public static double powerInt(double base, long exp) {
    	double temp; 
        if(exp == 0) 
        {
            return 1; 
        }
        temp = powerInt(base, exp/2);  
          
        if (exp%2 == 0) 
        {
            return temp*temp; 
        }
        else
        { 
            return base * temp * temp; 
        } 
 
    }
    
    private static double root(double base, long nthRoot) {
    	   	
    	if (nthRoot == 1)
    		return base;
    	
    	double upper = 1;
    	double lower = 0;
    	double baseEstimate = 1;
    	
    	for (double root = 1; baseEstimate < base; root++) {
    		baseEstimate *= powerInt(root, nthRoot);

    		if (base == baseEstimate) 
    			return root;
    		else 
    			upper = root;
    	}
    	
    	lower = upper - 1;
    	
    	return bisection(upper, lower, base, nthRoot);
    	
    }
    
    private static double bisection(double upper, double lower, double base, long nthRoot) {
    	
    	long iteration = 0;
    	double epsilon = 0.0000000001;
    	double middleEstimate;
    	double middle = 1;
    	
    	double absDifference = upper - lower;
    	if (absDifference < 0)
    		absDifference *= -1;
    	
    	while (absDifference > epsilon) {

    		middle = (upper+lower)/2;
    		middleEstimate = powerInt(middle, nthRoot);
    		
    		if (middleEstimate > base) 
    			upper = middle;
    		else
    			lower = middle;
    		
    		absDifference = upper - lower;
    		if (absDifference < 0)
        		absDifference *= -1;
    		
    		iteration++;
    		if (iteration == 1000)
    			break;
    	}
    	
    	return middle;
    }
    	
} 
