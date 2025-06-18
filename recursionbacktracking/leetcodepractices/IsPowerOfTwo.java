package recursionbacktracking.leetcodepractices;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(16);
        System.out.println("powerOfTwo --> " + powerOfTwo);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        if (n % 2 != 0){
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

}
