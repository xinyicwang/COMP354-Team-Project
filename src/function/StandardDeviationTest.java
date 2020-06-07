import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeviationTest {

    // test valid inputs
    @Test
    public void testStandardDeviation1() {
        double arr[] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};

        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double mean = (double)sum / (double)arr.length;

        double sqDiff = 0;
        for(int i = 0; i < arr.length; i++) {
            sqDiff += (arr[i] - mean) * (arr[i] - mean);
        }

        double res = Math.sqrt((double)sqDiff / (double)arr.length);

        assertEquals(res, StandardDeviation.standardDeviation(arr, arr.length), 0.00001);
    }
    
    // test valid inputs with negative numbers
    @Test
    public void testStandardDeviation2() {
        double arr[] = {1.0, -2.0, 3.0, 4.0, -5.0, 6.0};

        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double mean = (double)sum / (double)arr.length;

        double sqDiff = 0;
        for(int i = 0; i < arr.length; i++) {
            sqDiff += (arr[i] - mean) * (arr[i] - mean);
        }

        double res = Math.sqrt((double)sqDiff / (double)arr.length);

        assertEquals(res, StandardDeviation.standardDeviation(arr, arr.length), 0.00001);
    }
    
    // 	test one element in list
    @Test
    public void testStandardDeviation3() {
        double arr[] = {5.0};

        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double mean = (double)sum / (double)arr.length;

        double sqDiff = 0;
        for(int i = 0; i < arr.length; i++) {
            sqDiff += (arr[i] - mean) * (arr[i] - mean);
        }

        double res = Math.sqrt((double)sqDiff / (double)arr.length);

        assertEquals(res, StandardDeviation.standardDeviation(arr, arr.length), 0.00001);
    }
    
    // 	test one negative element in list
    @Test
    public void testStandardDeviation4() {
        double arr[] = {-6.0};

        double sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double mean = (double)sum / (double)arr.length;

        double sqDiff = 0;
        for(int i = 0; i < arr.length; i++) {
            sqDiff += (arr[i] - mean) * (arr[i] - mean);
        }

        double res = Math.sqrt((double)sqDiff / (double)arr.length);

        assertEquals(res, StandardDeviation.standardDeviation(arr, arr.length), 0.00001);
    }

}
