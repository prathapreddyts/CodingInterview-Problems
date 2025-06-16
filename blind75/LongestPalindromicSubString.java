package blind75;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String resultpalindromSubString = s.substring(0, 1);
        for (int center = 0; center < length; center++) {
            resultpalindromSubString = expandFromCenter(s, resultpalindromSubString, center, center);
            resultpalindromSubString = expandFromCenter(s, resultpalindromSubString, center, center + 1);
        }

        return resultpalindromSubString;
    }

    public String expandFromCenter(String string, String longestLPS, int left, int right) {
        int length = string.length();
        while (left >= 0 && right < length && string.charAt(left) == string.charAt(right)) {
            left++;
            right--;
        }
        String currentPalindromeString = string.substring(left + 1, right);
        if (currentPalindromeString.length() > longestLPS.length()) {
            return currentPalindromeString;
        } else {
            return longestLPS;
        }
    }

}
