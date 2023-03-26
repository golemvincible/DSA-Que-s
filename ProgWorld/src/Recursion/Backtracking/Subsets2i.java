package src.Recursion.Backtracking;
//https://leetcode.com/problems/subsets-ii/
//approach 1
import java.util.*;

public class Subsets2i {
    private static void helper(int[] nums,int ind,List<Integer> op,Set<List<Integer>> ans){
        if(ind==nums.length){
            ans.add(new ArrayList<>(op));
            return;
        }

        //include
        int ele=nums[ind];
        op.add(ele);
        helper(nums,ind+1,op,ans);
        op.remove(op.size()-1);

        //exclude
        helper(nums,ind+1,op,ans);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> op = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(nums,0,op,ans);

        for(List it:ans){
            res.add(new ArrayList<>(it));
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
