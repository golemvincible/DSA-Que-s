package binarysearch;

public class PeakIndexMountainArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int peak = peakInd(arr);
        System.out.println(findInArr(arr,peak,3));
    }

    private static int findInArr(int[] arr, int peak, int target) {
        int s=0,e=arr.length-1;

        if(target>arr[peak])
            return util(arr,peak+1,e,target);
        return util(arr,s,peak,target);
    }

    private static int util(int[] arr, int s, int e,int target) {
        while(s<=e){
            int mid=s+(e-s)/2;

            if(arr[mid]==target)
                return mid;

            if(target<arr[mid])
                e=mid-1;
            else
                s=mid+1;
        }
        return -1;
    }

    private static int peakInd(int[] arr) {
        int s=0,e=arr.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;

            if(arr[mid]<arr[mid+1])
                s=mid+1;
            else
                e=mid;
        }
        return s;
    }
}
