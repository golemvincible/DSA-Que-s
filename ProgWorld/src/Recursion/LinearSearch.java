package Recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String args[]){
        int[] arr = {3,2,1,1,9};
//        System.out.println(linearSearchFromFirst(arr,1,0));

//        System.out.println(linearSearchFromLast(arr,51,arr.length-1));

//        linearSearchFromMultipleOccurrence(arr,1,0);

//        ArrayList<Integer> list2 = new ArrayList<>();
//        multipleOccurence(arr,1,0,list2);
//        System.out.println(list2);

        ArrayList<Integer> res = multipleOccurence2(arr,1,0);
        System.out.println(res);

    }

    //  searching from first element
    static int linearSearchFromFirst(int[] arr,int target,int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target)
            return index;
        return  linearSearchFromFirst(arr,target,index+1);
    }

    //searching from last element
    static int linearSearchFromLast(int[] arr,int target,int index){
        if(index==-1){
            return -1;
        }
        if(arr[index]==target)
            return index;
        return  linearSearchFromFirst(arr,target,index-1);
    }


    //searching for multiple occurences approach 1
    static ArrayList<Integer> list = new ArrayList<>();
    static void linearSearchFromMultipleOccurrence(int[] arr,int target,int index){

        if(index==arr.length){
            return ;
        }

        if(arr[index]==target){
            list.add(index);
        }

        linearSearchFromMultipleOccurrence(arr,target,index+1);
    }


    //searching for multiple occurences approach 2(returning ArrayList)
    static ArrayList<Integer> multipleOccurence(int []arr,int target,int index,ArrayList<Integer> list2){
        if(index==arr.length-1) return list2;

        if(arr[index] == target)    list2.add(index);

        return multipleOccurence(arr,target,index+1,list2);
    }

    //searching for multiple occurences approach 3(returning ArrayList without passing arguments)
    static ArrayList<Integer> multipleOccurence2(int []arr,int target,int index){

        ArrayList<Integer> list2 = new ArrayList<>();

        if(arr.length == index){
            return list2;
        }

        if(arr[index] == target){
            list2.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = multipleOccurence2(arr,target,index+1);

        list2.addAll(ansFromBelowCalls);

        return list2;
    }

}
