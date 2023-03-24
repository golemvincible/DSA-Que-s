
package DynamicProgramming;
import java.util.*;
public class CutSegment {
    public static void main(String[] args) {
        Map<Integer,Integer> m = new HashMap<>();
        int n=8;
        int x=1,y=4,z=4;
        int[] arr = new int[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;
        int res = util(n,arr,m);
        if(res==Integer.MIN_VALUE){
            res=0;
        }
        System.out.println(res);
    }

    private static int util(int n, int[] arr,Map<Integer,Integer> m) {
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(m.containsKey(n)){
            return m.get(n);
        }
        int res=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int partialAns = util(n-arr[i],arr,m);
            if(partialAns!=Integer.MIN_VALUE){
                res = Math.max(res,partialAns+1);
            }
        }
        m.put(n,res);
        return m.get(n);
    }
}
