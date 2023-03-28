package src.Recursion.Backtracking;

import java.util.*;

public class PermutationsIIi {
    private static void helper(int[] nums,Set<List<Integer>> res,List<Integer> op,boolean[] vis){
        if(op.size()==nums.length){
            res.add(new ArrayList<>(op));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                op.add(nums[i]);
                helper(nums,res,op,vis);
                op.remove(op.size()-1);
                vis[i]=false;
            }
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        List<Integer> op = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        helper(nums,res,op,vis);

        List<List<Integer>> ans = new ArrayList<>();

        for(List it:res){
            ans.add(new ArrayList<>(it));
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2};
        System.out.println(permuteUnique(arr));
    }
}
