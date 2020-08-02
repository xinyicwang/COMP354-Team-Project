package function;

import gui.OneVariableEquation;

/**
 * Class to calculate the sin of a variable
 * 
 * @author Jenny Velicogna
 * 
 * @version 1.00
 *
 */

public class SinCalculator implements OneVariableEquation{
	
	private static final double  EPSILON = 0.0000001;
	
	private double pi;
	
	public static void main(String[] args) {

		
		
		//Test cases todo:
		
		/*
		SinCalculator scalc = new SinCalculator();
		
		assertEquals(Math.PI,scalc.pi,EPSILON);
		
		assertEquals(Math.sin(0),scalc.calculate(0),EPSILON);
		assertEquals(Math.sin(1),scalc.calculate(1),EPSILON);
		assertEquals(Math.sin(-1),scalc.calculate(-1),EPSILON);
		assertEquals(Math.sin(-5),scalc.calculate(-5),EPSILON);
		assertEquals(Math.sin(5),scalc.calculate(5),EPSILON);
		assertEquals(Math.sin(Math.PI),scalc.calculate(Math.PI),EPSILON);
		assertEquals(Math.sin(Math.PI * -1),scalc.calculate(Math.PI*-1),EPSILON);
		assertEquals(Math.sin(Math.PI * -2),scalc.calculate(Math.PI*-2),EPSILON);
		assertEquals(Math.sin(Math.PI * 2),scalc.calculate(Math.PI*2),EPSILON);
		*/
		

		
		//assertEquals(Math.pow(Math.PI, 0), calculator.powersOfPi(0), DELTA);
		
	}
	
	/**
	 * Constructor
	 */
	public SinCalculator() {
		pi = calculatePi(EPSILON);
	}
	
	public double getPI()
	{
		return pi;
	}
	
	/**
	 * Prints out the true value of pi, as well as our calculated value, and the 
	 * difference between the two
	 */
	
	public void checkPi() {
		double truePi = Math.PI;	
		double ourPi = calculatePi(EPSILON);
		double diff = Math.abs(truePi-ourPi);
		System.out.println("True pi: "+truePi+" | Our pi: | "+ourPi+" | Diff: "+diff);
	}
	
	/**
	 * Prints out the true sin of a number, as well as our calculated value, and the
	 * difference between the two
	 * @param num the number to take the sine of
	 */
	public void checkValue(double num) {
		double res1 = Math.sin(num);
		double res2 = calculateSin(num);
		double absdif = Math.abs(res1-res2);
		System.out.println("True value: "+res1+"  |  Our value: "+res2+"  |  ABS: "+absdif);
		
	}
	
	public double calculate(double num) {
		return calculateSin(num);
	}
	
	/**
	 * 
	 * @param num the number to calculate the sin of
	 * @return the sin of the number
	 */
	private double calculateSin(double num) {
		num = clampValue(num);
		return taylorSinApproximatePrecision(num,EPSILON);
		
	}
	
	/**
	 * Calculate the value of pie
	 * @param epsilon the precision of which to calculate pi up to
	 * @return
	 */
	public double calculatePi(double epsilon) {
		double ourepsilon = epsilon/4;//We calculate pi/4
		int i = 1;
		double res = 0;
		double lastres = 0;
		do {
			double sign = (i%2==0)?-1:1;
			int termFraction = 2*i-1;
			double toadd = sign*1/termFraction;
			lastres = res;
			res+=toadd;
			i++;
		}while (Math.abs(res-lastres) > ourepsilon);
		return res*4; //TODO: Calculate by hand
	}
	
	/**
	 * Uses the taylor sin approximation to calculate the sin of a value
	 * @param num The number to calculate (between -pi and pi)
	 * @param epsilon The precision of which to calculate
	 * @return the calculated value
	 */
	public double taylorSinApproximatePrecision(double num, double epsilon) {
		double res = 0;
		double lastres = 0;
		int i = 1;
		do{
			int termExponent = 2*i-1;
			double sign = (i%2==0)?-1:1;
			
			double toAdd = sign*positiveIntPower(num,termExponent)/positiveIntFactorial(termExponent);
			lastres = res;
			res+= toAdd;
			i++;
			
		}while (Math.abs(res-lastres) > epsilon);
		return res;
	}
	
	/**
	 * Calulates a number to the power of a positive integer
	 * @param num the base
	 * @param power the exponent
	 * @return the value of the calculation
	 */
	public double positiveIntPower(double num, int power) {
		double res = 1;
		
		for (int i = 0; i < power; i++) {
			res *= num;
		}
		return res;
	}
	
	/**
	 * Calculates the factorial of a number
	 * @param factor the number to factorialise
	 * @return the value of the factorial
	 */
	public double positiveIntFactorial(int factor) {
		double res = 1;
		
		for (int i = 1; i <= factor; i++) {
			 res *= i;
		}
		return res;
	}
	
	
	
	/**
	 * Clamps a value to be between -pi and pi, by adding or subtracting 2pi as nececerry
	 * @param val the value to clamp
	 * @return the clamped value
	 */
	public double clampValue(double val) {
		val += pi;
		val = absoluteModulus(val , pi*2);
		val -= pi;
		return val;
		
	}
	
	/**
	 * Calculate the modulus of a number, with negative numbers being calculated the same ways as positive (ex: -4 mod 3 returns 2 instead of 1) 
	 * @param a the number to take the modulus of
	 * @param b the modulus
	 * @return the value
	 */
	public double absoluteModulus(double a, double b) {
		return (a % b + b) % b;
	}

}
