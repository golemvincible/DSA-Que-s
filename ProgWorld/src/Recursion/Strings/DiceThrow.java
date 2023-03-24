package Recursion.Strings;

import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        String p = "";
        int target = 4;
        ArrayList<String> res = new ArrayList<>();
        res = util(p,target,res);
        System.out.println(res);
    }

    private static ArrayList<String> util(String p, int target, ArrayList<String> res) {
        if(target==0){
            res.add(p);
            return res;
        }
        for(int i=1;i<=6 && i<=target;i++){
            util(p+i,target-i,res);
        }
        return res;
    }

}
