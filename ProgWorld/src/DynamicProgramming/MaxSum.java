package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaxSum {
    public static void main(String[] args) {
        int[] arr={9,9,8,2};
        Map<Integer,Integer> m = new HashMap<>();
        int res = util(arr,0,m);
        System.out.println(res);
    }

    private static int util(int[] arr, int i, Map<Integer, Integer> m) {
        if(i>arr.length-1){
            return 0;
        }
        if(i==arr.length-1){
            return arr[arr.length-1];
        }
        if(m.containsKey(i)){
            return m.get(i);
        }
        int inc = util(arr,i+2, m) + arr[i];
        int exc = util(arr,i+1, m) + 0;
        int partialAns = Math.max(inc,exc);
        m.put(i,partialAns);
        return m.get(i);
    }
}
