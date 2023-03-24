package Recursion.Pattern;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]){
        int arr[] = {5,4,3,2,1};
        int r = arr.length-1;
        int c =0;
        bubbleSort(arr,r,c);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int []arr, int r,int c){
        if(r == 0){
            return;
        }
        //till c reaches r we are setting the largest element at last index
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }

            bubbleSort(arr,r,c+1);
        }
        //we have successfully set the largest element at last index not setting the second largest at second last index and so on
        else{
            bubbleSort(arr,r-1,0);
        }
    }
}
