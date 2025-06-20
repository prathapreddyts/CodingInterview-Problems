package recursionbacktracking.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSequences {
    public static void main(String[] args) {
        char[]current={0,0,0};
        ArrayList<String> ansList = new ArrayList<>();
        generateSequence(0,3,current,ansList);
        System.out.println(ansList.toString());

    }

    public static void generateSequence(int i, int n, char[] current, List<String> ans) {
        if (n == i) {
            ans.add(Arrays.toString(current));
            return;
        }
        current[i] = '4';
        generateSequence(i + 1, n, current, ans);
        current[i] = '5';
        generateSequence(i + 1, n, current, ans);

    }
}
