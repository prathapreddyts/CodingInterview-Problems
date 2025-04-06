package neetcodeArrays;

import static java.lang.Math.abs;

public class ScoreOfAString {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {

            int diff = s.charAt(i - 1) - (int) s.charAt(i);
            score += Math.abs(diff);
        }
        return score;

    }
}
