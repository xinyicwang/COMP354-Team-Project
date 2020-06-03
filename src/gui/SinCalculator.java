package gui;

public class SinCalculator {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float toCalc = 0.4014257f;
		
		
		
		
		
		
		
		//System.out.println("TEST1: " + positiveIntPower(4,4) );
		
		float res = calculateSin(toCalc);
		
		System.out.println("Val1: "+res);
		System.out.println("Val2: "+calculateSin(calculatePi()));
		System.out.println("Val3: "+calculateSin(calculatePi()/2));
		System.out.println("Val4: "+calculateSin(calculatePi()*4.5f));
		
		//Math.sin(res);
		
		

	}
	
	
	public static float calculateSin(float num) {
		//Note: Using DEGREES
		
		num = clampValue(num);
		
		return taylorSinApproximate(num,6);
		
		
		
	}
	
	public static float calculatePi() {
		return 3.14159265359f; //TODO: Calculate by hand
	}
	
	public static float taylorSinApproximate(float num, int terms) {
		float res = 0;
		for(int i = 1; i <= terms; i++) {
			int termExponent = 2*i-1;
			float sign = (i%2==0)?-1:1;
			
			float toAdd = sign*positiveIntPower(num,termExponent)/positiveIntFactorial(termExponent);
			res+= toAdd;
			
			
		}
		return res;
		
	}
	
	public static float positiveIntPower(float num, int power) {
		float res = 1;
		for(int i = 0; i < power; i++) {
			res *= num;
		}
		return res;
	}
	
	public static float positiveIntFactorial(int factor) {
		float res = 1;
		
		for(int i = 1; i <= factor; i++) {
			 res *= i;
		}
		return res;
	}
	
	
	
	
	public static float clampValue(float val) {
		
		float pi = calculatePi();
		
		val += pi;
		
		val = absoluteModulus(val , pi*2);
		
		val -= pi;
		
		return val;
		
	}
	
	public static float absoluteModulus(float a, float b) {
		return (a % b + b) % b;
	}

}
