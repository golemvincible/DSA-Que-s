package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountDearrangements {
    public static void main(String[] args) {
        Map<Integer,Integer> m = new HashMap<>();
        int n=2;
//        int res = utilRec(n,m);
        int res = utilTab(n);
        System.out.println(res);
    }

    private static int utilTab(int n) {
//        int dp[] = new int[n];
//        dp[1] = 0;
//        dp[2] = 1;
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1,0);
        m.put(2,1);

        for(int i=3;i<=n;i++){
            int first=m.get(i-1);
            int second=m.get(i-2);
            int res = (i-1)*(first+second);
            m.put(i,res);
        }
        return m.get(n);
    }

    private static int utilRec(int n,Map<Integer,Integer> m) {
        //base case
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(m.containsKey(n)){
            return m.get(n);
        }
        int res=(n-1)*(utilRec(n-2,m)+utilRec(n-1,m));
        m.put(n,res);
        return m.get(n);
    }

}
