package arrays;

public class CountOdd {
    public int countOdd(int[] arr, int n) {
        int oddCnt=0;
        for(int i:arr){
            if(i%2==1){
                oddCnt++;
            }
        }
        return oddCnt;

    }
}
