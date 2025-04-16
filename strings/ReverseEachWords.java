package strings;

public class ReverseEachWords {
    public String reverseWords(String s) {
        String trimmedString = s.trim();
        String[] splitString = trimmedString.split(" ");
        String result="";
        for(int i= splitString.length-1;i>=0;i--){
            if(i!=0){
                result+=splitString[i]+" ";
            }else{
                result+=splitString[i];
            }
        }
        return result;
    }
}