import java.util.*;

import function.Power2;

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
		//System.out.println(EPower.ePower(3.0 / 2.0));
		//System.out.println(Power.power(16, 0.5));
		
		//System.out.println(EPower.ePower(0.5));
		//System.out.println(Power2.powersOfPi(10));
		//System.out.println(Power2.powersOfPi(10));


	}

}
