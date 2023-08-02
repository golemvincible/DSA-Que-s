package src.dynamicProgrammingav.lis;

import java.util.Arrays;

public class MinimumNumberofRemovalstoMakeMountainArray {
    private static int solve(int[] arr,int m){
        int n = arr.length;
        //from front
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);

        for(int i=0;i<n;i++){
            int maxi=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    maxi = Math.max(dp1[j],maxi);
                }
            }
            dp1[i] = dp1[i] + maxi;

        }


        //from back
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);

        for(int i=n-1;i>=0;i--){
            int maxi=0;
            for(int j=n-1;j>i;j--){
                if(arr[j]<arr[i]){
                    maxi = Math.max(dp2[j],maxi);
                }
            }
            dp2[i] = dp2[i] + maxi;
        }

        //finding maximum bitonic sequence
        int res=0;
        for(int i=0;i<n;i++){
            /*
		       If the below conditional statement is not given, then strictly increasing or strictly
			   decreasing sequences will also be considered. It will hence fail in,
			   Test case: [10, 9, 8, 7, 6, 5, 4, 5, 4].

				We need to make sure both the LIS on the left and right, ending at index i,
				has length > 1.
		   */
            if(dp1[i]>1&&dp2[i]>1) // if element nums[i] is a valid peak,
                res=Math.max(res,dp1[i]+dp2[i]-1);

        }
        return res;

    }
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        return solve(arr, n);
    }
    public static int minimumMountainRemovals(int[] nums) {
        return nums.length - longestBitonicSequence(nums,nums.length);
    }

    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{2,1,1,5,6,2,3,1}));
    }
}
