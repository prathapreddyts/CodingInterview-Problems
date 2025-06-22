package recursion40DayChallenge;


    public class Subsequences {
        public static void main(String[] args) {
            String str = "abc";
            printSubsequences(str, "", 0);
        }

        static void printSubsequences(String str, String current, int index) {
            if (index == str.length()) {
                System.out.println(current);
                return;
            }
            printSubsequences(str, current + str.charAt(index), index + 1);
            printSubsequences(str, current, index + 1);
        }
    }

