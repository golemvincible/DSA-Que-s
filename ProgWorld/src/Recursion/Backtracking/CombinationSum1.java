package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum1 {
    private static void helper(int[] c, int t,int i,List<List<Integer>> res,List<Integer> ans){
        if(t<0)
            return;
        if(i==c.length){
            if(t==0){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if(c[i]<=t){
            //include
            ans.add(c[i]);
            helper(c,t-c[i],i,res,ans);
            ans.remove(ans.size()-1);
        }
        //exclude
        helper(c,t,++i,res,ans);
    }
    public static List<List<Integer>> combinationSum(int[] c, int t) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        helper(c,t,0,res,ans);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int t=8;
        System.out.println(combinationSum(arr,t));
    }
}
