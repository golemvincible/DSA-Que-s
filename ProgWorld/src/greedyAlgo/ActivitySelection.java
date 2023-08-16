package src.greedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    private static void solve(int[] s,int[] e){
        int act = 1; //already performing first activity

        //for recording the activities
        ArrayList<Integer> activities = new ArrayList<>();
        int let = e[0]; //let -> last ending time
        activities.add(0);
        for (int i = 1; i < e.length; i++) {
            if(let<=s[i]){
                //then we can perform that activity
                act++;
                activities.add(i);
                let = e[i];
            }
        }

        System.out.println(activities);
        System.out.println(act);
    }
    private static void solveUnsorted(int[] s,int[] e){
        int act = 1; //already performing first activity

        //for recording the activities
        ArrayList<Integer> activities = new ArrayList<>();

        int[][] a = new int[s.length][3];
        // 0 -> index
        // 1 -> st
        // 2 -> et
        // we have to sort according to end time

        for (int i = 0; i < a.length; i++) {
            a[i][0] = i;
            a[i][1] = s[i];
            a[i][2] = e[i];
        }

        //lambda fuction for sorting
        Arrays.sort(a, Comparator.comparingDouble(o -> o[2])); //this will sort the array acc t0o 2nd col i.e et

        int let = a[0][2]; //let -> last ending time
        activities.add(0);
        for (int i = 1; i < e.length; i++) {
            if(let<=a[i][1]){
                //then we can perform that activity
                act++;
                activities.add(a[i][0]);
                let = a[i][2];
            }
        }
        System.out.println(activities);
        System.out.println(act);
    }
    public static void main(String[] args) {
        solveUnsorted(new int[]{1,3,0,5,8,5},new int[]{2,4,6,7,9,9});
    }
}
