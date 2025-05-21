package strings;

public class DecomposableString {

    public static void main(String[] args) {
        String s = "0001111000";
        System.out.println(isDecomposable(s));
    }

    public static boolean isDecomposable(String s) {
        // Flag to track if a group of size 2 has been found
        boolean hasTwo = false;
        int n = s.length();
        int i = 0;

        // Iterate through the string
        while (i < n) {
            char ch = s.charAt(i);
            int count = 0;

            // Count consecutive occurrences of the character
            while (i < n && s.charAt(i) == ch) {
                count++;
                i++;
            }
            System.out.println(count);

            // If count % 3 == 1, it's invalid
            if (count % 3 == 1) {
                System.out.println("we are 30");
                return false;
            }
            // If count % 3 == 2, ensure it's the only such group
            else if (count % 3 == 2) {
                if (hasTwo) return false;
                hasTwo = true;
            }
        }

        return hasTwo;
    }
}



