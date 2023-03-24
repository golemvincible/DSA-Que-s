package DynamicProgramming;

public class PartitionSubsets {
    public static void main(String[] args) {
        int n=5,k=4;
        int res = util(n,k);
        System.out.println(res);
    }

    private static int util(int n, int k) {
        /*
            n==0 means we dont have anyone so no. of ways to divide them will be 0
            k==0 means we don't have any teams so no. of ways to divide people will be 0
            n<k means bo. of people are less than no. of teams so no. of ways will be 0 because
            each team must have atleast 1 player
        */
        if(n==0 || k==0 || n<k){
            return 0;
        }

        int[][] dp = new int[k+1][n+1];

        // t=teams,p=players

        for(int t=1;t<=k;t++){
            for (int p = 1; p <= n; p++) {
                if(t==p){
                    dp[t][p]=1;
                }else if(p<t){
                    dp[t][p]=0;
                }else{
                    dp[t][p] = t*(dp[t][p-1]) + dp[t-1][p-1];
                }
            }
        }
        return dp[k][n];
    }
}
