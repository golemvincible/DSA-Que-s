package Recursion;

public class SortedArr {
    public static void main(String args[]){
        int[] arr = {1,2,8,4,5};
        if(sortedArr(arr,0)){
            System.out.println("sorted");
        }else{
            System.out.println("not sorted");
        }
    }
    static boolean sortedArr(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }

        return arr[index]<arr[index+1] && sortedArr(arr,index+1);
    }
}
