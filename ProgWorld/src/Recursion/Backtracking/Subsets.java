package src.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static void helper(int[] nums, int ind, List<List<Integer>> res, List<Integer> ans){
        if(ind==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        //pick
        ans.add(nums[ind]);
        helper(nums,ind+1,res,ans);
        ans.remove(ans.size()-1);
        //unpick
        helper(nums,ind+1,res,ans);

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        helper(nums,0,res,ans);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }
}
