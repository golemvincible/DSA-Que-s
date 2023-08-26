package src.arrays;

public class MaxSumSubarray {
    //prefix sum
    public static int maxSubArray(int[] arr) {
        int[] ps = new int[arr.length];

        ps[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            ps[i] = ps[i-1]+arr[i];
        }

        int c=0,maxi=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currsum=0;
            for (int j = i; j < arr.length; j++) {

                currsum = i==0?ps[j]:ps[j]-ps[i-1];
                maxi=Math.max(maxi,currsum);
            }
        }

        return maxi;
    }
    private static int kedane(int[] arr){
        boolean check = false;
        int mini = Integer.MAX_VALUE;
        for (Integer it :
                arr) {
            if(it>0){
                check=true;
                break;
            }
            mini = Math.min(mini,it);
        }
        if(!check)  return mini;
        int maxi=Integer.MIN_VALUE,sum=0;

        for(Integer it:arr){
            sum+=it;
            if(sum<0)
                sum=0;
            maxi = Math.max(maxi,sum);
        }
        return maxi;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{2,4,6,8,10}));
        System.out.println(kedane(new int[]{2,4,6,8,10}));
    }
}
