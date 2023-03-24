package Recursion.Backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        String p = "";
        boolean[][] maze = {
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        int r=0,c=0;
        ArrayList<String> res = new ArrayList<>();
        res = path(p,maze,r,c,res);
        System.out.println(res);
    }

    private static ArrayList<String> path(String p, boolean[][] maze, int r, int c,ArrayList<String> res) {
        if(r == maze.length-1  &&  c == maze[0].length-1){
            res.add(p);
            return res;
        }
        if(maze[r][c] == false){
            return res;
        }
        if(r<maze.length-1){
            path(p+'D',maze,r+1,c,res);
        }
        if(c<maze[0].length-1){
            path(p+'R',maze,r,c+1,res);
        }
        return res;
    }
}
