import java.util.*;

import function.EPower;
import function.NRoot;
import function.Power;
import function.Power2;
import function.Exponentiation;
import function.StandardDeviation;
import function.Mean;


public class CalculatorApp {

	public static void main(String[] args) {
		List<Double> nums = new ArrayList<Double>();
        Scanner sc = new Scanner(System.in);
        // prompt for user input
        do {
            System.out.println("Current input is " + nums);
            System.out.println("Add more? (y/n)");
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

        // map user input into an array of doubles
        double[] doubles = new double[nums.size()];
        for(int i = 0; i < doubles.length; i++) {
            doubles[i] = nums.get(i);
        }
        int n = doubles.length;

        System.out.println("The standard deviation of " + n + " numbers is " + StandardDeviation.standardDeviation(doubles, n));
        System.out.println("The mean absolute deviation of the numbers is " + Mean.mad(doubles, n));
		System.out.println("hi");
		System.out.println("3^4 = " + Exponentiation.powerInt(3,4));
		System.out.println("25^3 = " + Exponentiation.powerInt(25,3));
		System.out.println("2^-2 = " + Exponentiation.powerInt(2,-2));
		System.out.println(EPower.ePower(3.0 / 2.0));
		System.out.println(Power.power(16, 0.5));
		
		System.out.print(Power2.power(10, 2.1));

		List<Double> nums = new ArrayList<Double>();
        Scanner sc = new Scanner(System.in);
        // prompt for user input
        do {
            System.out.println("Current input is " + nums);
            System.out.println("Add more? (y/n)");
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

        // map user input into an array of doubles
        double[] doubles = new double[nums.size()];
        for(int i = 0; i < doubles.length; i++) {
            doubles[i] = nums.get(i);
        }
        int n = doubles.length;

        System.out.println("The standard deviation of " + n + " numbers is " + StandardDeviation.standardDeviation(doubles, n));
        System.out.println("The mean absolute deviation of the numbers is " + Mean.mad(doubles, n));
		
	}

}
