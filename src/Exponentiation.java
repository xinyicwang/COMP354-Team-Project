import java.util.*;

public class Exponentiation {

	
    /**
     * Function that calculates the exponentiation given a base number and an integer power number
     * @param base: base number
     * @param exp: exponent number
     * @return exponentiation of base number to the power of exponent number
     */
	
    private static double powerInt (double base, int exp) {
    	int result = 1;
    	char sign = 'p';
    	
    	if (exp < 0) {
    		exp *= -1;
    		sign = 'n';
    	}
    		
    	for (int i = 0; i < exp; i++) {
    		result *= base;
    	}
    	    	
    	if (sign == 'p')
    		return result;
    	else
    		return ((double)1/result);
    }
    	
	public static void main(String[] args) {
		System.out.println("3^4 = " + powerInt(3,4));
		System.out.println("25^3 = " + powerInt(25,3));
		System.out.println("2^-2 = " + powerInt(2,-2));
	}

}
