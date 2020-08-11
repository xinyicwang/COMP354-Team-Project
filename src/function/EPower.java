/*
 * EPower
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

import Exceptions.*;

/**
 * This class calculates the transcendental function e raised to the power x.
 * This functions uses the Taylor Series Algorithm and Honers rule to appromximate the root
 * @version 24 July 2020
 * @author Thuyohn Thurai Sivagnanam 40044860
 */
public class EPower {
	
    /**
     * Function that calculates the exponential of the constant e
     * @author Thuyohn Thurai Sivagnanam
     * @param exponent: exponent number
     * @return exponential of constant e using Horner's rule to approximate roots
     */

	public static double ePower(double exponent) throws InfinityException, InvalidInputException{
		 
		/*
		 * N is a random number to get the right precision.
		 */
        int N = 1000;
        
        /*
         * pN will be the polynomial that you calculate iteratively
         */
        double pN = 1 + exponent/N;
        
        /*
         *  with the use of the Horner's rule to approximated the roots.
         */
        while (--N >= 1) {
            pN = 1 + exponent/N*pN;
        }
        
        return pN;
	}
}
