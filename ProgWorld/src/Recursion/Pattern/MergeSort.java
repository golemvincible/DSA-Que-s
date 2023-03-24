package Recursion.Pattern;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]){
        int[] arr = {5,4,3,2,1};
        int ans[] = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort(int[] arr) {

        //only 1 element remaining so can't divide further
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return sortedMerged(left,right);
    }

    static int[] sortedMerged(int[] left, int[] right) {
        //mixed sorted array
        int[] res = new int[left.length + right.length];

        //traverse left array
        int i=0;

        //traverse right array
        int j=0;

        //traverse mixed array
        int k=0;

        while(i!=left.length && j!=right.length){
            if(left[i]<right[j]){
                res[k] = left[i];
                i++;
            }
            else{
                res[k] = right[j];
                j++;
            }
            k++;
        }

        //either left or right array is empty or both are empty

        //if left array is empty but right is not
        if(i == left.length && j != right.length){
            while (j!=right.length){
                res[k] = right[j];
                j++;
                k++;
            }
        }
        //if right array is empty but left is not
        else if(j == right.length && i != left.length){
            while (i!=left.length){
                res[k] = left[i];
                i++;
                k++;
            }
        }
        return res;
    }
}
