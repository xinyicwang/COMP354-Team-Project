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

    // mean absolute diff
    @Test
    public void testMean() {
        double arr[] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};

        double absSum = 0;

        for(int i = 0; i < arr.length; i++) {
            absSum += absSum + Math.abs(arr[i] - mean(arr, arr.length));
        }

        double res = absSum;

        assertEquals(res, Mean.mad(arr, arr.length), 0.00001);
    }

}