package arrays;

public class IsArraySorted {
    boolean arraySortedOrNot(int[] arr, int n) {
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                    return false;
            }
        }
        return true;
    }
}
