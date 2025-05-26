package basicmath;

public class ReverseNumber {
    public int reverseNumber(int n) {
        int revNumber=0;
        while(n>0){
            int remainder=n%10;
            revNumber=revNumber*10+remainder;
            n=n/10;
        }
        return revNumber;
    }
}
