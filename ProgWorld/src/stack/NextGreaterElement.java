package stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr={1,3,2,4};

        arr = nextG(arr);

        for (int i :
                arr) {
            System.out.print(i+" ");
        }
    }

    private static int[] nextG(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n-1,j=0; i >= 0; i--,j++) {
            if(st.isEmpty()){
                res[j]=-1;
                st.push(res[j]);
            }
            else if(st.peek()>arr[i])
                res[j]=st.peek();
            else{
                while(!st.isEmpty() && st.peek()<arr[i])
                    st.pop();
                if(st.isEmpty())
                    res[j]=-1;
                else
                    res[j]=st.peek();
            }

        }
        return res;
    }
}
