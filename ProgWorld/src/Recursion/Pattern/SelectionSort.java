package Recursion.Pattern;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String args[]){
        int arr[] = {4,3,2,1};
        int r = arr.length;
        int c =0;
        //we are always assuming that maximum element is at 0th index then comparing others with it
        int maxEleInd = 0;
        selectionSort(arr,r,c,maxEleInd);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int []arr, int r,int c, int maxEleIndex){
        if(r==0){
            return;
        }

        //till c reaches r
        if(c<r){
            if(arr[c]>arr[maxEleIndex]){
                selectionSort(arr,r,c+1,c);
            }
            else {
                selectionSort(arr,r,c+1,maxEleIndex);
            }
        }
        //so far we have only conpared and got index of largest element
        //now we only have to set element at maxEleIndex at last index
        else{
            int temp = arr[maxEleIndex];
            arr[maxEleIndex] = arr[r-1];
            arr[r-1] = temp;

            //we will again pretend that our max element is at 0th index and continue for next line
            selectionSort(arr,r-1,0,0);
        }
    }
}
