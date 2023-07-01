package src.dynamicProgrammingav;

import java.util.ArrayList;

public class MinimumSubsetSumDifference {
    private static void subsetSumTabulation(int n, int arr[], int sum,int[][] dp){
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=sum;i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1]<=j){
                    if(dp[i-1][j-arr[i-1]] !=0 || dp[i-1][j] !=0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for (int[] it :
                dp) {
            for (int i :
                    it) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
    private static int[][] fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[1].length;j++)
                dp[i][j]=-1;
        }
        return dp;
    }
    static ArrayList<Integer> isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N+1][sum+1];

        fill(dp);

        subsetSumTabulation(N, arr, sum, dp);

        ArrayList<Integer> selected = new ArrayList<>();

        for (int i=0;i<=sum/2;i++){
            if(dp[N][i]==1)  selected.add(i);
        }
        System.out.println(selected);
        return selected;
    }

    static int minSubsetSum(int[] arr,int n){
        int range = 0;

        for(int i:arr)  range+=i;

        ArrayList<Integer> selected = isSubsetSum(n,arr,range);

        int minm = Integer.MAX_VALUE;

        for (int i = 0; i < selected.size(); i++) {
            minm = Math.min(minm,range-2*selected.get(i));
        }

        return minm;
    }
    public static void main(String[] args) {
        int[] a = {1,2,7};
        int n = 3;

        System.out.println(minSubsetSum(a,n));

    }
}
