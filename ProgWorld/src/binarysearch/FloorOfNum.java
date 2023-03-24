package binarysearch;

public class FloorOfNum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        System.out.println(floor(arr,15));
    }

    private static int floor(int[] arr, int target) {
        int s=0,e=arr.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid]==target)
                return arr[mid];

            if(target>arr[mid])
                s=mid+1;
            else
                e=mid-1;
        }
        return arr[e];
    }
}
