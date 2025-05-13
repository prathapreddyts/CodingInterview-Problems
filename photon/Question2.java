package photon;

import  java.util.*;

public class Question2 {
    public static void main(String[] args) {
        /*
         Input: "0111000111"
         Output: "0000111111"
        */


        //approach1("0111000111");
        optimised("0111000111");
        /*
        Approach 1
        space and time :O(n) and time O(n) and I will sort algo Ologn
        * I will convert it to array and do doing type cast it into int and the
        * I will do sort it and convert back to string

        Approach 2
        it will take O(n) time complexity and :I will count 0 and 1 and then return a new string O(n) or I will manipulate the same with O(1)
        * */



    }
    public static  void approach1(String inpStr){
        /*
        *
        * Time comp:O(n)
        * Space Comp:O(n)
        *
        * */

        ArrayList<Integer> intArray = new ArrayList<>();
        for(int i=0;i<inpStr.length();i++){
            intArray.add(Integer.valueOf(inpStr.charAt(i)));
        }
        Collections.sort(intArray);
        String result="";
        for(int i=0;i<intArray.size();i++){
            Integer ch = intArray.get(i);
            result+=Character.toString(ch);
        }
        System.out.println(result);
    }
    public static void optimised(String intStr){
        int oneCount=0;
        int twoCount=0;
        for(int i=0;i<intStr.length();i++){
            if(intStr.charAt(i)=='0'){
                oneCount++;
            }else{
                twoCount++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder str = stringBuilder.append(intStr);
        str.replace(0,oneCount,"0");
        str.replace(oneCount,twoCount,"1");
        System.out.println(str.toString());
    }
}
