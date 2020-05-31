package function;

public class Power {
	
	
	public static double power(double base, double exponent) {
		
		if(exponent == 0.0)
		{
			return 1;
		}
		
		int nRoot = 1;
		
		// if exponent is decimal, split into numerator and denominator
		if(exponent % 1 != 0) {
			double temp_exp = exponent;
			int numerator = 0, denominator = 1;
			
			while (temp_exp % 1 != 0) {
				temp_exp *= 10.0;
				denominator *= 10;
			}
			numerator = (int) Math.round(temp_exp);
			exponent = numerator;
			nRoot = denominator;
		}
		
		double tempPow = base;
		
		for(int i = 0 ; i < exponent - 1 ; ++i) {
			tempPow *= base;
		}
		
		return NRoot.nRoot(tempPow, nRoot);
	}
	
}
