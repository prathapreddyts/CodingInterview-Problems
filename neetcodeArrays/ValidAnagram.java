package neetcodeArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] hash = new int[26];
        for (int i = 0; i < sChars.length; i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (int num : hash) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
