package advantest;

import java.util.*;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        twoSum();
    }

    public static void twoSum(){
        ArrayList<Integer> usrInput = new ArrayList<>();
        int target=12;
        usrInput.add(1);
        usrInput.add(5);
        usrInput.add(3);
        usrInput.add(7);
        usrInput.add(9);

        Collections.sort(usrInput);
        List<List<Integer>> resulLists=new ArrayList<>();
        int start=0;
        int end=usrInput.size()-1;
        while(start<end){
            ArrayList<Integer> innerList = new ArrayList<>();
            if(usrInput.get(start)+usrInput.get(end)==target){
                innerList.add(usrInput.get(start));
                innerList.add(usrInput.get(end));
                resulLists.add(innerList);
                start++;
                end--;
            }
           else if(usrInput.get(start)+usrInput.get(end)>target){
                end--;
            }else{
               start++;
            }
        }

        System.out.println(resulLists);

    }
}
