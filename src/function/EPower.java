package function;

public class EPower {
		
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
        return pN;
	}
}