package src.prefixSum;
//https://leetcode.com/problems/sum-of-distances/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumofDistances {
    private static long[] helper(int[] nums,int n){
        /*
            it will store all the all the indexes of same elements
            eg. 1,3,1,1,2
            so it will store 1 -> {0,2,3}
                             2 -> {4}
                             3 -> {1}
        */
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!m.containsKey(nums[i])){
                m.put(nums[i],new ArrayList<Integer>());
                ArrayList arr = m.get(nums[i]);
                arr.add(i);
                m.put(nums[i],arr);
            }
            else{
                ArrayList arr = m.get(nums[i]);
                arr.add(i);
                m.put(nums[i],arr);
            }
        }

        long[] res = new long[n];

        for(Integer ele:m.keySet()){
//            System.out.print(ele + " ");
            ArrayList<Integer> indexes = m.get(ele);
            long totalSum=0;

            for(Integer idx:indexes){
                totalSum+=(long)idx;
            }
            //prefix sum
            long prefixSum=0;
            for(int i=0;i<indexes.size();i++){

                int idx = indexes.get(i);
                long postSum = totalSum-prefixSum-idx;

                //left
                res[idx] += (idx*(long)i);
                res[idx] -= prefixSum;  //prefixSum -> sum of all previous elements

                //right
                res[idx] -= (idx*(long)(indexes.size()-1-i));
                res[idx] += postSum;

                prefixSum+=idx;
            }
        }
        return res;
    }
    public static long[] distance(int[] nums) {

        return helper(nums,nums.length);
    }
    public static void main(String[] args) {
        int[] arr = {1,13,1,1,13,1,13};
        System.out.println(Arrays.toString(distance(arr)));
    }
}
