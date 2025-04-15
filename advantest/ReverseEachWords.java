package advantest;

public class ReverseEachWords {
    public static void main(String[] args) {
        String usrInput="Good Morning";
        String[] splitString = usrInput.split(" ");
        String reverseString= "";
        String [] reverseList=new String[splitString.length];
        int ide=0;
        for(int i=0;i<splitString.length;i++){
            String s = splitString[i];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            StringBuilder reverse = stringBuilder.reverse();
            reverseList[ide]=reverse.toString();
            ide++;
        }
        for(int i=0;i<reverseList.length;i++){
            if(i!=reverseList.length){
                reverseString=reverseString+reverseList[i]+" ";
            }else{
                reverseString=reverseString+reverseList[i];
            }
        }
        System.out.println(reverseString);

    }
}
