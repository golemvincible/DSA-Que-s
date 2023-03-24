package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofDistinctIslands {
    private static void dfs(int[][] grid, boolean[][] vis, ArrayList<Integer> l, int i, int j, int[] root, int[][] dirs){

        int m=vis.length;
        int n=vis[0].length;

        vis[i][j]=true;
        int x = i - root[0];
        int y = j - root[1];
        l.add(x);
        l.add(y);

        for(int[] dir: dirs){
            int a = i + dir[0];
            int b = j + dir[1];

            if(a<0 || b<0 || a>=m || b>=n || vis[a][b] || grid[a][b]==0)  continue;

            dfs(grid,vis,l,a,b,root,dirs);
        }
    }
    static int countDistinctIslands(int[][] grid) {


        int m=grid.length,n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        HashSet<ArrayList<Integer>> s = new HashSet<>();
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    ArrayList<Integer> l = new ArrayList<>();
                    int[] root = {i,j};
                    dfs(grid,vis,l,i,j,root,dirs);
                    s.add(l);
                }
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        int[][] test = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0}};
        System.out.println(countDistinctIslands(test));
    }
}
