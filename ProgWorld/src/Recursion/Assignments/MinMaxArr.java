package Recursion.Assignments;

//Program to find Minimum and Maximum elements of array
public class MinMaxArr {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        int min = arr[0];
        int max = arr[0];
        util(arr,min,max);

    }

    //approach 1 finding min max element by passing elements
    static int index = 0;
    private static void util(int[] arr, int min, int max) {
        if(index>=arr.length){
            System.out.println(min);
            System.out.println(max);
            return;
        }

        if(max<arr[index]){
            max = arr[index];
        }
        if(min>arr[index]){
            min = arr[index];
        }
        index++;
        util(arr,min,max);
    }

}
