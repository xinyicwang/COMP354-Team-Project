import java.util.*;

public class CalculatorApp {

	public static void main(String[] args) {
		List<Double> nums = new ArrayList<Double>();
        Scanner sc = new Scanner(System.in);
        // prompt for user input
        do {
            System.out.println("Current input is " + nums);
            System.out.println("Add another number? (y/n)");
            if(sc.next().startsWith("y")) {
                System.out.println("Enter: ");
                nums.add(sc.nextDouble());
            }
            else {
                break;
            }
        } while(true);
        
        sc.close();
        System.out.println("List is " + nums);

        double[] doubles = new double[nums.size()];
        for(int i = 0; i < doubles.length; i++) {
            doubles[i] = nums.get(i);
        }
        int n = doubles.length;

        System.out.println("The mean absolute deviation of the numbers is " + mad(doubles, n));
                
	}
	
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
		
	private static double mad(double arr[], int n)
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
