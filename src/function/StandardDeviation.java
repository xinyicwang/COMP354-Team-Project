package function;

public class StandardDeviation {

    /**
     * Function that calculates the absolute value of a number
     * @param num: a number of type double
     * @return the absolute value of number n
     */
    private static double abs(double num) {
        return (num < 0) ? -num : num;
    }

    /**
     * Function that calculates the square of a number
     * @param n: base number
     * @param i: auxiliary number
     * @param j: auxiliary number
     * @return the result of base multiplied by itself
     */
    private static double square(double n, double i, double j) {
        double mid = (i + j) / 2;
        double mult = mid * mid;
        if((mult == n) || (abs(mult - n) < 0.00001)) {
            return mid;
        }
        else if(mult < n) {
            return square(n, mid, j);
        }
        else {
            return square(n, i, mid);
        }
    }

    /**
     * Function that calculates the square root value of a number
     * @param num: base number
     * @return the square root of the base
     */
    private static double sqrt(double num) {
        double i = 1;
        double res = 0;
        boolean found = false;
        while(!found) {
            if (i * i == num) {
                found = true;
            }
            else if(i * i > num) {
                res = square(num, i - 1, i);
                found = true;
            }
            i++;
        }
        return res;
    }

    /**
     * Function that calculates the variance of an array of numbers
     * @param arr: array of doubles
     * @param n: length of the array
     * @return the variance of the array
     */
    private static double variance(double arr[], int n) {
        double sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double mean = (double) sum / (double) n;
        // sum squared difference with mean
        double sqdiff = 0;
        for(int i = 0; i < n; i++) {
            sqdiff += (arr[i] - mean) * (arr[i] - mean);
        }
        return (double) sqdiff / n;
    }

    /**
     * Function that calculates the standard deviation of an array of numbers
     * @param arr: array of doubles
     * @param n: length of the array
     * @return the standard deviation of the array
     */
    public static double standardDeviation(double arr[], int n) {
        return sqrt(variance(arr, n));
    }

	
}