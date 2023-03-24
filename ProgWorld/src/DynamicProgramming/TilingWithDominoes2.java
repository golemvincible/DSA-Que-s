package DynamicProgramming;

public class TilingWithDominoes2 {
    public static void main(String[] args) {
        int n=39,m=16;
        int[] dp=new int[n+1];
        System.out.println(solve(n,m,dp));
    }

    private static int solve(int n, int m, int[] dp) {
        if(n<m){
            return 1;
        }
        if(n==m){
            return 2;
        }
        return solve(n-1,m,dp)+solve(n-m,m,dp);
    }
}
