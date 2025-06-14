package blind75;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grpMap = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);  // use as key

            if (!grpMap.containsKey(sorted)) {
                grpMap.put(sorted, new ArrayList<>());
            }
            grpMap.get(sorted).add(s);
        }

        return new ArrayList<>(grpMap.values());
    }
}
