package binarysearch.searchSpace;

public class MinimumTimetoRepairCars {
    public static long repairCars(int[] ranks, int cars) {
        long s=1,e=(long)1e14;


        while(s<=e){
            //mid -> some minutes
            long mid=s+(e-s)/2;
            /*
                we are calculating for each mechanic in mid minutes how many cars can he repair
                then,
                we are adding them (they will be our repaired cars) so we will get to know that in mid minutes how many
                total cars we can repair.
                if we can't repair the given amount of cars then we will increase our mid i.e time
                if we can repair given amount of cars in mid minutes then we know for certain that we can repair our cars in
                mid minutes so we will calculate minimum minutes so we will make our e=mid-1
            */
            long repairedCars=0;
            for(int r:ranks){
                repairedCars+=Math.sqrt(mid/r);
            }
            if(repairedCars<cars){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,3,1};
        long ans = repairCars(arr,10);
        System.out.println(ans);
    }
}
