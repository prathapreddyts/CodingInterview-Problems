package strings;

public class Palindrome {
    public static void main(String[] args) {
        boolean palindromeResult = isPalidromeInteger(1212);
        System.out.println(palindromeResult);
    }

    public static boolean isPalidromeInteger(Integer inputInt) {
        int reverseNumber=0;
        int org=inputInt;
        while(inputInt>0){
            int rem = inputInt % 10;
            reverseNumber=reverseNumber*10+rem;
            inputInt=inputInt/10;
        }
        if(org-reverseNumber!=0){
            return false;
        }

        return true;
    }

    public static boolean isPalidrome(String inpString) {
        int left = 0;
        int right = inpString.length() - 1;
        while (left < right) {
            Character leftChar = inpString.charAt(left);
            Character rightChar = inpString.charAt(right);
            if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }



}
