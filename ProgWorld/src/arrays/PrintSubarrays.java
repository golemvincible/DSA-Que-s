package src.arrays;

public class PrintSubarrays {
    private static void solve(int[] arr){
        int c=0,maxi=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
//            int localsum=0;
            for (int j = i; j < arr.length; j++) {
//                int subarraySum=0;
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
//                    subarraySum+=arr[k];
                }
                System.out.print("]");
                c++;
//                localsum=Math.max(localsum,subarraySum);
            }
//            c=Math.max(c,localsum);
            System.out.println();
        }

    }
    public static void main(String[] args) {
        solve(new int[]{2,4,6,8,10});
    }
}
