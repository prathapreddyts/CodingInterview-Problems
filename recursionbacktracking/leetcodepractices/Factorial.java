package recursionbacktracking.leetcodepractices;

public class Factorial {
    public long factorial(int n) {
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }

}
