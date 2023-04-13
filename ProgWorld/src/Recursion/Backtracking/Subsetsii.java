package src.Recursion.Backtracking;

//https://leetcode.com/problems/subsets/
//approach 2 best approach
import java.util.ArrayList;
import java.util.List;

public class Subsetsii {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(subsets(arr));

    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> op = new ArrayList<>();

        helperSubsets(nums,op,res,0);

        return res;
    }

    private static void helperSubsets(int[] nums, List<Integer> op, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(op));

        for(int i=start;i<nums.length;i++){
            op.add(nums[i]);
            helperSubsets(nums,op,res,i+1);
            op.remove(op.size()-1);
        }
    }
}
