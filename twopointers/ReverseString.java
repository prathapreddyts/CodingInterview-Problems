package twopointers;

public class ReverseString {
    public void reverseString(char[] str) {
        int start=0;
        int end=str.length-1;
        while(start<end){
            char tempChar = str[start];
            str[start]=str[end];
            str[end]=tempChar;
            start++;
            end--;
        }

    }
    public void reverseStringUsingArr(char[] str) {
        int len = str.length - 1;
        for (int i = 0; i < str.length / 2; i++) { // Run loop only till half
            char temp = str[i];
            str[i] = str[len - i]; // Corrected index calculation
            str[len - i] = temp;
        }
    }

}
