package DynamicProgramming;

public class TilingWithDominoes {
    public static void main(String[] args) {
        int n=8;
        int dp[] = new int[n+1];
        System.out.println(solve(n,dp));
        System.out.println(solve2(n));
    }
    //recursion
    private static int solve(int n,int[] dp) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int res = solve(n-1,dp)+solve(n-2,dp);
        dp[n] = res;
        return dp[n];
    }
    //tabulation
    static int solve2(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
