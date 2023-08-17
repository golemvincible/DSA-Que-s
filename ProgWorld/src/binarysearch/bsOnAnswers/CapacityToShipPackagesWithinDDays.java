package src.binarysearch.bsOnAnswers;

public class CapacityToShipPackagesWithinDDays {
    private static boolean isSafe(int[] weights, int days,int minW){
        int shippedW=0;
        int c=1;
        for(int it:weights){

            // if(days<=0)
            //     return false;

            if((shippedW+it)<=minW){
                shippedW+=it;
            }
            else{
                c++;
                shippedW=it;
            }
        }

        return c<=days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e=0;
        int res=0;

        for(int it:weights){
            s=Math.max(s,it);
            e+=it;
        }

        while(s<=e){
            int mid=s+(e-s)/2;

            if(isSafe(weights,days,mid)){
                res=mid;
                e=mid-1;
            }
            else
                s=mid+1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{7,7,7,7,12,7,7},45));
    }
}
