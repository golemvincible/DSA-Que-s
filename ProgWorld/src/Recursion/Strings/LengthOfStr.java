package Recursion.Strings;

//length of string using recursion
public class LengthOfStr {
    public static void main(String args[]){
        String str = "abjdbfjd";
        int len = 0;
        int index = 0;
        len = util(str,len);
        System.out.println(len);
    }

    private static int util(String str, int len) {
        if(str.isEmpty()){
            return len;
        }
        return util(str.substring(1),++len);
    }
}
