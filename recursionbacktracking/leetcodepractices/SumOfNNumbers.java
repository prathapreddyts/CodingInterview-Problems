package recursionbacktracking.leetcodepractices;

public class SumOfNNumbers {
    public int NnumbersSum(int n) {
        if(n==0){
            return n;
        }
        return n+NnumbersSum(n-1);
    }
}
