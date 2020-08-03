package function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeanTest {

    private static double mean(double arr[], int n) {
        double sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double mean = (double)sum / (double)arr.length;

        return mean;
    }

    // test valid input with answer found using MAD calculator
    @Test
    public void testMean1() {
        double arr[] = {10.0, 15.0, 15.0, 17.0, 18.0, 21.0};

        //Used MAD calculator to verify the results.
        assertEquals(2.66667, Mean.mad(arr), 0.00001);
    }
    
    // test valid input with answer found using MAD calculator
    public void testMean2() {
        double arr[] = {10.0, -15.0, 17.0, -17.0, 18.0, 21.0};

        //Used MAD calculator to verify the results.
        assertEquals(14.44444, Mean.mad(arr), 0.00001);
    }
    
    // test one input
    @Test
    public void testMean3() {
        double arr[] = {10};

        double absSum = 0;

        for(int i = 0; i < arr.length; i++) {
            absSum += absSum + Math.abs(arr[i] - mean(arr, arr.length));
        }

        double res = absSum;

        assertEquals(res, Mean.mad(arr), 0.00001);
    }
    
    // test negative input
    @Test
    public void testMean4() {
        double arr[] = {-21.5};

        double absSum = 0;

        for(int i = 0; i < arr.length; i++) {
            absSum += absSum + Math.abs(arr[i] - mean(arr, arr.length));
        }

        double res = absSum;

        assertEquals(res, Mean.mad(arr), 0.00001);
    }

}
