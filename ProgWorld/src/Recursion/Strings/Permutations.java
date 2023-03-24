package Recursion.Strings;

import java.util.ArrayList;

public class Permutations {
    public static void main(String args[]){
        String str = "abc";
        ArrayList<String> res = new ArrayList<>();
        int index = 0;
        String output = "";
        permutations(str,output,res,index);
    }

    private static void permutations(String str,String output, ArrayList<String> res, int index) {
        if(index>=str.length()){
            res.add(output);
            return;
        }

    }
}
