package recursionbacktracking.leetcodepractices;

public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(3 / 3);
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
