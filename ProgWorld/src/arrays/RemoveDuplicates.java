package arrays;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

//approach 1: two pointers
public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        int res = helper(arr);
        System.out.println(res);
    }

    private static int helper(int[] nums) {
        int i=0;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
