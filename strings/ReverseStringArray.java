package strings;

import java.util.Vector;

public class ReverseStringArray {
    public Vector<Character> reverseString(Vector<Character> s) {
        int start=0;
        int end=s.size()-1;
        while(start<end){
            Character tempChar = s.get(start);
            s.set(start,s.get(end));
            s.set(end,tempChar);
            start++;
            end--;
        }
        return s;
        //your code goes here
    }
}
