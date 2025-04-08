package neetcodeArrays;

public class ConcatinationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] result = new int[2 * n];
        for(int i=0;i<=2*n-1;i++){
            result[i]=nums[i%n];
        }
        return  result;
    }
}
