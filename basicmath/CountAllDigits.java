package basicmath;

public class CountAllDigits {
    public int countDigit(int n) {
        if(n==0){
            return 1;
        }
        int digitCount=0;
        while(n>0){
            digitCount++;
            n=n/10;
        }
        return digitCount;

    }
}
