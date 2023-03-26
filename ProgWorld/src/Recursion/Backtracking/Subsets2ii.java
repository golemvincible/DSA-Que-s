package src.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2ii {
    private static void helper(int[] nums,int ind,List<Integer> op,List<List<Integer>> res){

        res.add(new ArrayList<>(op));


        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1])
                continue;

            op.add(nums[i]);
            helper(nums,i+1,op,res);
            op.remove(op.size()-1);
        }


    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(nums,0,op,res);

        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,2,2};
        System.out.println(subsetsWithDup(arr));
    }
}
