package src.greedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class FractionalKnapsack {
    private static double solve(int w,Item a[],int n){
        double ans = 0;
        double[][] ratios = new double[n][2];
        // 0 -> for storing indexes as to keep track when we sort this array
        // 1 -> it will store value of ratios

        int k=0;
        for(Item it:a){
            ratios[k][0] = k;
            ratios[k][1] = it.value/(double)it.weight;
            k++;
        }

        Arrays.sort(ratios, Comparator.comparingDouble(o -> o[1]));

        for(int i=n-1;i>=0 && w>0;i--){
            /*
             * desc order mai chahiye isliye i=n-1 se start kar rahe as array is currently sorted in asc order
             * a[ratios[i][0]] means
             * ratios[i][0] will select the last array doing it because we are sorted in asc order
             * at 0th index we have stored indexes so we will take that
             * now put it in a[] to get actual items stored in that index in actual array
             */
            Item it = a[(int)ratios[i][0]];


            int weight = it.weight;
            int val = it.value;

            if(weight<=w){
                // no problem we will get full value for it
                ans+= val;
                w-= weight;
            }
            else{
                //then we will take partially
                ans+= ratios[i][1]*w;
                w=0;
            }
        }

        return ans;
    }
    //Function to get the maximum total value in the knapsack.
    static double fractionalKnapsack(int W, Item arr[], int n)
    {
        return solve(W,arr,n);
    }

    public static void main(String[] args) {
        Item[] it = new Item[3];
        int[] val = {60,100,120};
        int[] w = {10,20,30};

        for (int i = 0; i < 3; i++) {
            it[i] = new Item(val[i], w[i]);
        }

        System.out.println(fractionalKnapsack(50,it,3));
    }
}
