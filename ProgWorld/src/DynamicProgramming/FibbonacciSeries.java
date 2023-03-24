package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//fibonacci series using dp
public class FibbonacciSeries {
    public static void main(String[] args) {
        Map<Integer,Integer> dp = new HashMap<Integer,Integer>();
        int n = 6;
        int res = util(n,dp);
        System.out.println(res);
    }

    private static int util(int n, Map<Integer, Integer> dp) {
        if(n<=1){
            return n;
        }

        if(dp.containsKey(n)){
            return dp.get(n);
        }
        dp.put(n,util(n-1,dp)+util(n-2,dp));

        return dp.get(n);
    }
}
