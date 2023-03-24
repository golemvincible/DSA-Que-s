package Recursion.Strings;

import java.util.ArrayList;

//subsets of strings
public class Subsets {
    public static void main(String args[]){
        String str = "abcc";
        ArrayList<String> ans = new ArrayList<>();
        String op = "";
        int index=0;
        util(str,ans,op,index);
        System.out.println(ans);
    }

    private static void util(String str, ArrayList<String> ans, String op, int index) {

        //base condition
        if(index>=str.length()){
            ans.add(op);
            return;
        }

        //exclude
        util(str,ans,op,index+1);

        //include
        char ch = str.charAt(index);
        util(str,ans,op+ch,index+1);
    }
}
