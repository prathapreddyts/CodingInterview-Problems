package recursionbacktracking.scaler;

public class NFactorial {
    public int factorialOfN(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorialOfN(n - 1);
    }
}
