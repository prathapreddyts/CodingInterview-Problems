package recursionbacktracking.leetcodepractices;

public class SumOfNNaturalNumbers {
    public static void main(String[] args) {

    }

    public static int sumOfNNumbers(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNNumbers(n - 1);
    }
}
