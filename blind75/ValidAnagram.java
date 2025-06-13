package blind75;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            s2[t.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;

    }
}
