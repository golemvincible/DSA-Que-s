package Recursion.Backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        int r=3;
        int c=3;
        ArrayList<String> arr = new ArrayList<>();
        String p ="";
        arr = path(p,r,c,arr);
        System.out.println(arr);
    }


    static ArrayList<String> path(String p, int r, int c,ArrayList<String> res) {
        if (r == 1 && c == 1) {
            res.add(p);
            return res;
        }

        if (r > 1) {
            path(p + 'D', r-1, c,res);
        }

        if (c > 1) {
            path(p + 'R', r, c-1,res);
        }
        return res;
    }
}
