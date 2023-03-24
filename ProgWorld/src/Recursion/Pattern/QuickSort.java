package Recursion.Pattern;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]){
        int arr[] = {5,4,3,2,1};
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low>=high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = arr[m];

        //taking pivot to its place
        while (s<=e){

            while (arr[s]<pivot) {
                s++;
            }
            while (arr[e]>pivot){
                e--;
            }

            /*if my s is still less than e than their's only one possibility
            * that any element is violating its rule or is in wrong place
            * then we'll swap element from first side to element from second side
            * of pivot element or maybe pivot element itself*/
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        //pivot is at right position
        //dividing the array now across pivot int two halves
        quickSort(arr,low,e);
        quickSort(arr,s,high);

    }
}
