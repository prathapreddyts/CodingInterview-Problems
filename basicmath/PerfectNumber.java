package basicmath;

public class PerfectNumber {
    public boolean isPerfect(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        return n==sum;
    }
}
