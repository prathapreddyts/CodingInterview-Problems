package advantest;

import java.util.*;

public class StringPermutations {
    public static List<String> getPermutations(String input) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        System.out.println(queue.size());

        for (char ch : input.toCharArray()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                for (int i = 0; i <= current.length(); i++) {
                    String perm = current.substring(0, i) + ch + current.substring(i);
                    if (perm.length() == input.length()) {
                        result.add(perm);
                    } else {
                        queue.add(perm);
                    }
                }
            }
        }

        return result;
    }

}
