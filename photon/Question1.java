package photon;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        int [] numbers={1,2,3,4};
        int prd=1;
        for(int i:numbers){
            prd=prd*i;
        }
        int[] result = new int[numbers.length];
        int indx=0;
        for(int i=0;i<numbers.length;i++){
            result[indx]=prd/numbers[i];
            indx++;
        }
       for(int i:result){
           System.out.println(i);
       }


    }
}
