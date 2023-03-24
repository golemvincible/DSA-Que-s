package Recursion.Strings;

public class PhoneNumberLettr {
    public static void main(String[] args) {
        String str = "12";
        String res = "";
        util(str,res);
    }

    private static void util(String up, String p) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch = (char)('a'+i);
            util(up.substring(1),p+ch);
        }
    }
}
