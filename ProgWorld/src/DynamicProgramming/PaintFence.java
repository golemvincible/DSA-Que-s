package DynamicProgramming;

public class PaintFence {
    public static void main(String[] args) {
        int n=5;
        int k=3;
//        int res = solve(n,k);
        int res = solve2(n,k);
        System.out.println(res);
    }

    private static int solve(int n, int k) {
        int[] dp = new int[n];
        int same=k*1;
        int diff=k*(k-1);
        dp[1] = same + diff;

        for(int i=2;i<dp.length;i++){
            same = diff*1;
            diff=dp[i-1]*(k-1);
            dp[i] = same+diff;
        }
        return dp[n-1];
    }
    private static int solve2(int n, int k) {
        int tot = 0;
        int same=k*1;
        int diff=k*(k-1);
        tot = same + diff;

        for(int i=3;i<=n;i++){
            same = diff*1;
            diff=tot*(k-1);
            tot = same+diff;
        }
        return tot;
    }
}
