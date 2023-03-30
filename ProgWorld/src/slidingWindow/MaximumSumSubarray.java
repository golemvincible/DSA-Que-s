package src.slidingWindow;

public class MaximumSumSubarray {

    private static int maxSumSubarray(int[] nums,int k){
        int i=0,j=0;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;

        while(j<nums.length){
            sum+=nums[j];
            // j-i+1 -> window
            //we are making the window
            if(j-i+1<k){
                j++;
            }
            //reached the window
            else{
                maxSum=Math.max(maxSum,sum);
                sum-=nums[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSumSubarray(nums,3));
    }
}
