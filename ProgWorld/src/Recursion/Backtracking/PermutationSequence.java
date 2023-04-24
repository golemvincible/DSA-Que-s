package src.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    static int count=0;
    static String res="";
    private static String subs(List<Integer> ans){
        String op="";
        for(Integer it:ans){
            op = op + (char)(it+'0');
        }
        return op;
    }
    private static boolean util(int n,int k,int c,String op,List<Integer> ans){
        if(ans.size()==n){
            count++;
            if(count==k) {
                res = subs(ans);
                System.out.println(res);
                return true;
            }
            return false;
        }

        for(int i=1;i<=n;i++){
            if(ans.contains(i))
                continue;

                ans.add(i);
                if (util(n, k, c, op, ans)) return true;
                ans.remove(ans.size()-1);

        }
        return false;
    }
    public static String getPermutation(int n, int k) {

        String op="";
        util(n,k,0,op,new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,1));
    }
}
