package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class HighwayBillboardProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int n = sc.nextInt();

        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }

        int[] revenue = new int[n];
        for (int i = 0; i < n; i++) {
            revenue[i] = sc.nextInt();
        }

        int minDis = sc.nextInt();
        HashMap<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            m.put(positions[i],revenue[i]);
        }
        System.out.println(util(length,positions,revenue,minDis));
        System.out.println(util2(length,positions,revenue,minDis,m));
    }

    private static int util(int length, int[] positions, int[] revenue, int minDis) {
        int[] dp = new int[positions.length];
        int res=0;

        dp[0] = revenue[0];

        for (int i = 1; i < positions.length; i++) {
            int maxRev=0;
            for (int j = 0; j < i; j++) {

                if(positions[j]+minDis<positions[i]){
                    if(maxRev<dp[j]){
                        maxRev=dp[j];
                    }
                }
            }
            dp[i] = maxRev+revenue[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    private static int util2(int length, int[] positions, int[] revenue, int minDis, HashMap<Integer, Integer> m) {
        int[] dp = new int[length+1];
        int res=0;

        dp[0] = 0;

        for (int i = 1; i <= length; i++) {

            //udhr koi board hai hi nhi to dp[i] = dp[i-1] hi hoga max revenue
            if(!m.containsKey(i)){
                dp[i] = dp[i-1];
            }


            /*
                2 option hai
                       case1:ya to udhar board nahi lgaye to dp[i] = dp[i-1] ke equal ho jayega
                                                vs
                       case2:udhr board hai to hum minimum distance peeche jayenge qki utni jagah koi board nhi lg skta uske pehle
                       ka jo max hai vo lenge + utni jagah board nhi lg skta to uska 0 + current mile pr jo board ka revenue

                       dono ka max le lenge
            */
            else{
                int case1 = dp[i-1];
                int case2=m.get(i);
                if(i>=minDis+1)
                    case2 = dp[i-minDis-1] + 0 + m.get(i);
                dp[i]=Math.max(case1,case2);
            }
        }
        res = dp[length];
        return res;
    }
}
