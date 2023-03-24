package Recursion.Strings;
//remove a's from the string
public class StringQue1 {
    public static void main(String args[]){
        String str = "baccdah";
        String res = "";
        util1(str,res);
        str = util2(str);
        System.out.println(str);

    }

    private static String util2(String str) {
        if(str.isEmpty()){
            return str;
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            return util2(str.substring(1));
        }
        else{
            return ch + util2(str.substring(1));
        }
    }

    private static void util1(String str, String res) {

        if(str.isEmpty()){
            System.out.println(res);
            return;
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            util1(str.substring(1),res);
        }
        else{
            util1(str.substring(1),res+ch);
        }
    }

}
