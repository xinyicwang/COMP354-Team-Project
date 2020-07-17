package gui;

public class SinCalculator {
	
	private static final double  EPSILON = 0.01;
	
	private double pi;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		SinCalculator scalc = new SinCalculator();
		
		
		//System.out.println("TEST1: " + positiveIntPower(4,4) );
		
		//double res = calculateSin(toCalc);
		
		//scalc.checkPi();
		
		
		scalc.checkValue(0);
		System.out.println(scalc.calculate(3.1));
		//SinCalculator.checkValue(calculatePi());
		//SinCalculator.checkValue(calculatePi()/2);
		//SinCalculator.checkValue(calculatePi()*4.5);
		//SinCalculator.checkValue(1);
		
		
		
		
		//Math.sin(res);
		
		

	}
	
	public SinCalculator() {
		pi = calculatePi(EPSILON);
	}
	
	public void checkPi() {
		double truePi = Math.PI;	
		double ourPi = calculatePi(EPSILON);
		double diff = Math.abs(truePi-ourPi);
		System.out.println("True pi: "+truePi+" | Our pi: | "+ourPi+" | Diff: "+diff);
	}
	
	public void checkValue(double num) {
		double res1 = Math.sin(num);
		double res2 = calculateSin(num);
		double absdif = Math.abs(res1-res2);
		System.out.println("True value: "+res1+"  |  Our value: "+res2+"  |  ABS: "+absdif);
		
	}
	
	public double calculate(double num) {
		return calculateSin(num);
	}
	
	
	
	
	private double calculateSin(double num) {
		
		num = clampValue(num);
		
		
		return taylorSinApproximatePrecision(num,EPSILON);
		
		
		
	}
	
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
		}while(Math.abs(res-lastres) > ourepsilon);
		return res*4; //TODO: Calculate by hand
	}
	
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
			
		}while(Math.abs(res-lastres) > epsilon);
		return res;
	}
	
	public double taylorSinApproximate(double num, int terms) {
		double res = 0;
		for(int i = 1; i <= terms; i++) {
			int termExponent = 2*i-1;
			double sign = (i%2==0)?-1:1;
			
			double toAdd = sign*positiveIntPower(num,termExponent)/positiveIntFactorial(termExponent);
			res+= toAdd;
			
			
		}
		return res;
		
	}
	
	public double positiveIntPower(double num, int power) {
		double res = 1;
		
		for(int i = 0; i < power; i++) {
			res *= num;
		}
		return res;
	}
	
	public double positiveIntFactorial(int factor) {
		double res = 1;
		
		for(int i = 1; i <= factor; i++) {
			 res *= i;
		}
		return res;
	}
	
	
	
	
	public double clampValue(double val) {
		val += pi;
		val = absoluteModulus(val , pi*2);
		val -= pi;
		return val;
		
	}
	
	public double absoluteModulus(double a, double b) {
		return (a % b + b) % b;
	}

}
