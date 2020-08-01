<<<<<<< HEAD
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

=======
package function;

>>>>>>> origin/standard-deviation
public class EPower {
	
    /**
     * Function that calculates the exponential of the constant e
<<<<<<< HEAD
     * @author Thuyohn Thurai Sivagnanam
=======
>>>>>>> origin/standard-deviation
     * @param exponent: exponent number
     * @return exponential of constant e using Horner's rule to approximate roots
     */

<<<<<<< HEAD
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
        
=======
	public static double ePower(double exponent) {
        
		// N is a random number to get the right precision.
        int N = 1000;
        //pN will be the polynomial that you calculate iteratively
        double pN = 1 + exponent/N;
        
        // with the use of the Horner's rule to approximated the roots.
        // Starting from the most innermost brackets. 
        while (--N >= 1) {
            pN = 1 + exponent/N*pN;
        }
>>>>>>> origin/standard-deviation
        return pN;
	}
}