package function;

public class NRoot {
	
	// Newtons method
	public static double nRoot(double base, double root) {
		
		// 1th root of any number is the same number
		if(root == 1)
		{
			return base;
		}
		
		// Random initial guess x0
		double x0 = Math.random() % 10;
		
		// Defines accuracy of calculation
		double epsilon = 0.001;
		
		// Used to check when desired precision is achieved
		double deltaX = Integer.MAX_VALUE;
		
		// current value of xK
		double currentX = 0.0;
		
		while(deltaX > epsilon) {
			
			double pow = x0;
			for(int i = 0 ; i < root - 2 ; ++i) {
				pow *= x0;
			}
		}
		
		return currentX;
	}
}
