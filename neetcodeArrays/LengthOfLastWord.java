package neetcodeArrays;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] splitedString = s.split(" ");
        return splitedString[splitedString.length-1].length();

    }
}
