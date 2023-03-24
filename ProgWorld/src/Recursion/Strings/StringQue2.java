package Recursion.Strings;
//remove apple from the string

public class StringQue2 {

    public static void main(String args[]){
        String str = "bahsfapplekfjg";
        str = skipApple(str);
        System.out.println(str);
    }

    private static String skipApple(String str) {
        if(str.isEmpty()){
            return str;
        }

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }
        else{
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }
}
