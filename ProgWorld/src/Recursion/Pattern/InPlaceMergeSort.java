package Recursion.Pattern;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String args[]){
        int[] arr = {5,4,3,2,1};
        int start = 0;
        int end = arr.length;

        inPlaceMergeSort(arr,start,end);
        System.out.println(Arrays.toString(arr));
    }

    static void inPlaceMergeSort(int[] arr, int start, int end) {
        if(end-start == 1){
            return;
        }

        int middle = (start + end)/2;
        inPlaceMergeSort(arr,start,middle);
        inPlaceMergeSort(arr,middle,end);

        merge(arr,start,middle,end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int merged[] = new int[end-start];

        int i = start; //will traverse first array
        int j = middle; //will traverse second array
        int k = 0;  //will traverse merged array

        while(i!=middle && j!=end){
            if(arr[i]<arr[j]){
                merged[k] = arr[i];
                i++;
            }
            else{
                merged[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i!=middle){
            while(i!=middle){
                merged[k] = arr[i];
                i++;
                k++;
            }
        }
        else if(j!=end){
            while(j!=end){
                merged[k] = arr[j];
                j++;
                k++;
            }
        }
        for(int l=0;l<merged.length;l++){
            arr[start+l] = merged[l];
        }
    }

}
