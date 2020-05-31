package function;

public class Mean {

	private static double abs(double num)
	{
		return (num <0) ? -num : num;
	}
		
	private static double sum(double arr[])
	{
		double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
	}
	
	/**
     * Function that calculates the mean absolute deviation of an array of numbers
     * @param arr: array of doubles
     * @param n: length of the array
     * @return the mean absolute deviation of the array
     */
		
	public static double mad(double arr[], int n)
	{
		 
	     double mean = sum(arr) / (double) n;
	     
	     double abdiff = 0;
	     
	     for(int i = 0; i < n; i++) {
	            abdiff += abs((arr[i] - mean)) ;
	        }
	     
	     abdiff = (abdiff /n);
	        
		return abdiff;
		
	}

	
}
