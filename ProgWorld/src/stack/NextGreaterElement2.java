package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int n=nums.length;

        int[] res = new int[n];

        // int maxE=Integer.MIN_VALUE;

        for(int i=2*n-1;i>=0;i--){

            int ele = nums[i%n];

            //maintain ngl in the stack
            while(!st.isEmpty() && st.peek()<=ele){
                st.pop();
            }

            //we will start filling nge array after completing 1 traversal of nums array
            if(i<n){
                if(!st.isEmpty()){
                    res[i]=st.peek();
                }
                else{
                    res[i]=-1;
                }
            }

            st.push(nums[i%n]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
