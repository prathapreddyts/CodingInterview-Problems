package basicmath;

public class FactorialNumber {
    public int factorial(int n) {
        int ans=1;
        for(int i=n;i>=1;i--){
            ans=ans*n;
        }
        return ans;
    }

}
