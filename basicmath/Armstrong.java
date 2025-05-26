package basicmath;

public class Armstrong {
    public boolean isArmstrong(int n) {
        int orgNum=n;
        return doCalculation(n)==orgNum;
    }

    public int doCalculation(int n) {
        int n1 = n;
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        int sum = 0;
        while (n1 > 0) {
            sum = sum + (int) Math.pow(n1 % 10, count);
            n1 = n1 / 10;
        }
        return sum;
    }
}
