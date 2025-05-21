package recursionbacktracking.recursion;

public class IsPalindrome {
    public boolean palindromeCheck(String s) {
        return palindromeHelper(0,s.length()-1,s);
    }

    public boolean palindromeHelper(int start, int end, String s) {
        if (start >= end) {
            return true; // Base case: all characters matched
        }
        return s.charAt(start) == s.charAt(end) && palindromeHelper(start + 1, end - 1, s);
    }
}
