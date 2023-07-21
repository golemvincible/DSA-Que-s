package src.dynamicProgrammingav;

import java.util.Arrays;

public class CoinChangeII {
    private static int util(int amnt,int[] coins,int ind,int[] dp){
        if(amnt==0) return 1;

        if(amnt<0)  return 0;

        if(dp[amnt]!=-1)    return dp[amnt];

        int ways=0;

        for(int i=ind;i<coins.length;i++){
            ways+=util(amnt-coins[i],coins,i,dp);
        }
        return dp[amnt] = ways;
    }
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);

        return util(amount,coins,0,dp);
    }

    public static void main(String[] args) {
        int[] arr = {3,5,7,8,9,10,11};

        System.out.println(change(500,arr));
    }
}
