package basicmath;

public class CountOddDigits {
    public int countOddDigit(int n) {
        int oddCount=0;
        if(n==0){
            return 1;
        }
        while(n>0){
            if(n%2!=0){
                oddCount++;
            }
            n=n/10;
        }
        return oddCount;

    }
}
