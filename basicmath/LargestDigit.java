package basicmath;

public class LargestDigit {
    public int largestDigit(int n) {
        if(n==0){
            return 0;
        }
        int maxDigit=Integer.MIN_VALUE;
        while(n>0){
            maxDigit=Math.max(n%10,maxDigit);
            n=n/10;

        }
        return maxDigit;
    }
}
