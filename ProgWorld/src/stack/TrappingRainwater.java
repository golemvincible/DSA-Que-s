package stack;

// https://leetcode.com/problems/trapping-rain-water/submissions/

//approach 1 but memory usage is high so we'll optimise it using stack
public class TrappingRainwater {
    public static int trap(int[] h) {

        int n = h.length;

        int[] leftM = new int[n];
        int[] rightM = new int[n];

        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(h[i]>max)
                max=h[i];
            leftM[i]=max;
        }

        max=Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            if(h[i]>max)
                max=h[i];
            rightM[i]=max;
        }

        int res=0;

        for(int i=0;i<n;i++){
            res+=Math.min(leftM[i],rightM[i])-h[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
