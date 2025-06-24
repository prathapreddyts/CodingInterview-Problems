package recursion40DayChallenge;

public class PermutateAString {
    public static void main(String[] args) {
        char[]ans=new char[3];
        char[] inp={'a','b','c'};
        boolean[] used=new boolean[3];
        permute(ans,0,used,inp,3);
    }
    public static void permute(char[] ans, int index, boolean[] used, char[] inpChar, int n) {
        if (index == n) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                ans[index] = inpChar[i];
                permute(ans, index + 1, used, inpChar, n);
                used[i] = false;
            }

        }
    }
}
