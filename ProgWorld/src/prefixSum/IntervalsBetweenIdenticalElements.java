package src.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/intervals-between-identical-elements/
public class IntervalsBetweenIdenticalElements {
    public static long[] getDistances(int[] nums) {
        int n=nums.length;
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

            ArrayList<Integer> indexes=m.get(ele);
            long totalSum=0;

            for(Integer ind:indexes)
                totalSum+=ind;

            long preSum=0;  //left is 0 for 1st ele
            for(int i=0;i<indexes.size();i++){
                int index = indexes.get(i);

                long postSum = totalSum-preSum-index;

                //left
                res[index]+=i*(long)index;
                res[index]-=preSum;  //preSum -> sum of all previous elements

                //right
                res[index]-=index*(long)(indexes.size()-i-1);
                res[index]+=postSum;

                preSum+=index;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,1,2,3,3};
        System.out.println(Arrays.toString(getDistances(arr)));
    }
}
