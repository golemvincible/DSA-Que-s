package dfsTrav;

public class CheckKnightTourConfiguration {
    private static void dfs(int[][] grid,boolean[][] vis,int[] xdirs,int[] ydirs,int x,int y,int c){

        int n=grid.length;

        vis[x][y]=true;
        c++;

        for(int i=0;i<xdirs.length;i++){

            int newX=x+xdirs[i];
            int newY=y+ydirs[i];

            if(newX>=n || newY>=n || newX<0 || newY<0 || vis[newX][newY] || grid[newX][newY]!=c)   continue;

            dfs(grid,vis,xdirs,ydirs,newX,newY,c);
        }

    }
    public static boolean checkValidGrid(int[][] grid) {

        int[] xdirs = {-2,-2,2,2,-1,-1,1,1};
        int[] ydirs = {-1,1,-1,1,-2,2,-2,2};

        int n=grid.length;

        boolean[][] vis = new boolean[n][n];

        dfs(grid,vis,xdirs,ydirs,0,0,0);

        //if any block remains unvisited we will return false
        for(boolean[] arr:vis){
            for(boolean it:arr){
                if(!it)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        System.out.println(checkValidGrid(grid));
    }
}
