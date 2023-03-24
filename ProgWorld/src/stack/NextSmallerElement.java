package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    private static void nextSmaller(int arr[], int n) {
        // code here
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int ele=arr[i];

            //stack will maintain next smaller element at top
            while(!st.isEmpty() && st.peek()>=ele)
                st.pop();

            if(st.isEmpty())
                arr[i]=-1;
            else
                arr[i]=st.peek();
            st.push(ele);

        }
    }

    public static void main(String[] args) {
        int[] res = {5,6,2,3,1,7};

        nextSmaller(res,res.length);

        System.out.println(Arrays.toString(res));
    }
}
