package basicmath;

import java.util.Arrays;

public class DivisorsOfNumber {
    public int[] divisors(int n) {
        int[] tempCount=new int[n];
        int idx=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                tempCount[idx]=i;
                idx++;
            }
        }
        return Arrays.copyOf(tempCount,idx);
    }
}
