package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(util(nums));
    }

    private static int util(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res=1;

        for (int i = 1; i < nums.length; i++) {

            int max=0;
            for (int j = 0; j < i; j++) {
                /*
                    1. Pehle dekhenge kis kiske neeche lag skta hai
                    2. Phir dekhenge max subsequence konsa hai unme se uske neeche laga denge
                */
                //1
                if(nums[j]<nums[i]){
                    //2
                    if(dp[j]>max)
                        max=dp[j];
                }
            }
            dp[i] = max+1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
