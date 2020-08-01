package function;

public class Exponentiation {


    /**
     * Function that calculates the exponential given a base number and an integer power number
     * @param base: base number
     * @param exp: exponent number
     * @return exponentiation of base number to the power of exponent number
     */

    public static double powerInt(double base, double exp) {
    	int result = 1;
    	char sign = 'p';

    	if (exp < 0) {
    		exp *= -1;
    		sign = 'n';
    	}

    	double remainder = exp % 1;
    	exp = exp - remainder;

    	for (int i = 0; i < exp; i++) {
    		result *= base;
    	}

    	if (sign == 'p')
    		return result;
    	else
    		return ((double)1/result);
    }

}
