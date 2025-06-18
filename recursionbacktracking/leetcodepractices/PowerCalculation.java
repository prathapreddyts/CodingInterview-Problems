package recursionbacktracking.leetcodepractices;

public class PowerCalculation {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        long N = n; // convert to long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0){
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

}
