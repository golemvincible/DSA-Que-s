package Recursion.Backtracking;

import java.util.ArrayList;

//to solve maze problem if all directions unlocked
public class BackTracking_1 {
    public static void main(String[] args) {
        int r=0;
        int c=0;
        boolean maze[][] = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        String p = "";
        ArrayList<String> res = new ArrayList<>();
        res = path(p,maze,r,c,res);
        System.out.println(res);
    }
    static ArrayList<String> path(String p, boolean [][]maze, int r, int c, ArrayList<String> res){

        //need to reach 3,3 (destination)
        if(r==maze.length-1 && c==maze[0].length-1){
            res.add(p);
            return res;
        }

        //checking if the block is already visited (no recursion call for already visited)
        if(maze[r][c]==false){
            return res;
        }

        //taking a step
        maze[r][c] = false;


        //directions

        //down
        if(r<maze.length-1){
            path(p+'D',maze,r+1,c,res);
        }

        //right
        if(c<maze[0].length-1){
            path(p+'R',maze,r,c+1,res);
        }

        //up
        if(r>0){
            path(p+'U',maze,r-1,c,res);
        }

        //left
        if(c>0){
            path(p+'L',maze,r,c-1,res);
        }

        //reverting all the changes
        maze[r][c] = true;

        return res;
    }
}
