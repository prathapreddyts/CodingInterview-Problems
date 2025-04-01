package twopointers;

public class MinNumberOfMoveToMakePalindrome {
    public int minMovesToMakePalindrome(String s) {
        char[] chars = s.toCharArray();
        int moves = 0;
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                int k = right;
                while (k > left && chars[k] != chars[left]) {
                    k--;
                }
                if (k == left) {
                    moves += chars.length / 2 - left;
                    left++;
                } else {
                    for (int i = k; i < right; i++) {
                        char temp = chars[i];
                        chars[i] = chars[i + 1];
                        chars[i + 1] = temp;
                        moves++;
                    }
                    right--;
                }
            }
        }
        return moves;
    }
}
