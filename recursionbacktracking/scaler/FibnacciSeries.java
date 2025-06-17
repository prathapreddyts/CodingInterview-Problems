package recursionbacktracking.scaler;

public class FibnacciSeries {
    public int fibNseries(int n) {
        if (n <= 1) {
            return n;
        }
        return fibNseries(n - 1) + fibNseries(n - 2);
    }
}
