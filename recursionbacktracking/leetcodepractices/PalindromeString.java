package recursionbacktracking.leetcodepractices;

public class PalindromeString {
    public boolean isPalindrome(String subString, int start, int end) {
        if (start >= end) {
            return true;
        }
        return subString.charAt(start) == subString.charAt(end) && isPalindrome(subString, start + 1, end - 1);
    }
}
