package binarysearch;

public class BinarySearch {
    static int search(int[] nums, int target,int s,int e){

        int m = s + (e-s)/2;

        //base condition
        if(s>e){
            return -1;
        }

        if(target == nums[m]){
            return m;
        }
        else if(target<nums[m]){
            return search(nums,target,s,m-1);
        }
        else if(target>nums[m]){
            return search(nums,target,m+1,e);
        }

        return -1;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int res = search(arr,12,0, arr.length-1);
        if(res==-1)
            System.out.println("Not found");
        else
            System.out.println(res);
    }
}
